package io.hhplus.tdd.domain.point.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.TransactionType;
import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.infra.PointHistoryRepositoryImpl;
import io.hhplus.tdd.infra.UserPointRepositoryImpl;
import io.hhplus.tdd.domain.point.service.request.UserPointRequest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PointServiceTest {

  @Mock
  private UserPointRepositoryImpl userPointRepository;

  @Mock
  private PointHistoryRepositoryImpl pointHistoryRepository;

  @Mock
  private UserPointTable userPointTable;

  @InjectMocks
  private PointServiceImpl pointService;
  @DisplayName("사용자는 현재 포인트를 조회할 수 있다.")
  @Test
  void getPoint() {
    //given
    long id = 1L;
    UserPoint userPoint = new UserPoint(1L, 100L, System.currentTimeMillis());

    given(userPointRepository.findById(anyLong()))
        .willReturn(userPoint);

    //when
    UserPoint resultUserPoint = pointService.point(id);
    //then
    assertThat(resultUserPoint.id())
        .isNotNull()
        .isEqualTo(id);
    assertThat(resultUserPoint)
        .isEqualTo(userPoint);
  }

  @DisplayName("사용자는 포인트 충전/사용 내역을 조회할 수 있다.")
  @Test
  void getHistory() {
    //given
    long userId = 1L;
    List<PointHistory> pointHistoryList = List.of(
        new PointHistory(1L, userId, 1000L, TransactionType.CHARGE, System.currentTimeMillis()-3),
        new PointHistory(2L, userId, 500L, TransactionType.USE, System.currentTimeMillis()-2),
        new PointHistory(3L, userId, 300L, TransactionType.CHARGE, System.currentTimeMillis()-1)
    );
    given(pointHistoryRepository.findById(anyLong()))
        .willReturn(pointHistoryList);

    //when
    List<PointHistory> resultPointHistoryList = pointService.history(userId);

    //then
    assertThat(resultPointHistoryList.size())
        .isEqualTo(pointHistoryList.size());
    assertThat(resultPointHistoryList)
        .isEqualTo(pointHistoryList);
  }
  @DisplayName("사용자는 포인트를 충전할 수 있다.")
  @Test
  void chargePoint() {
    /**
     * existinguserPoint: 충전 전 포인트 정보
     * chargedUserPoint:  충전 된 포인트 정보
     * userPointRequest:  충전 할 포인트 요청 정보
     */
    //given: usedUserPoint = existinguserPoint - userPointRequest
    UserPoint existinguserPoint = new UserPoint(1L, 100L, System.currentTimeMillis());
    UserPoint chargedUserPoint = new UserPoint(1L, 500L, System.currentTimeMillis());

    UserPointRequest userPointRequest = UserPointRequest.builder()
        .id(1L)
        .point(400L)
        .build();

    given(userPointRepository.findById(anyLong()))
        .willReturn(existinguserPoint);

    given(userPointRepository.save(any(UserPointRequest.class)))
        .willReturn(chargedUserPoint);

    //when: 포인트 충전 서비스 호출
    UserPoint resultUserPoint = pointService.charge(userPointRequest);

    //then: 결과 값 검증
    assertThat(resultUserPoint.id())
        .isNotNull()
        .isEqualTo(userPointRequest.getId());
    assertThat(resultUserPoint.point())
        .isNotNull()
        .isEqualTo(existinguserPoint.point() + userPointRequest.getPoint());
  }

  @DisplayName("사용자는 포인트를 사용할 수 있다.")
  @Test
  void usePoint() {
    /**
     * existinguserPoint: 사용 전 포인트
     * usedUserPoint:     사용 된 포인트 정보
     * userPointRequest:  사용 할 포인트 요청 정보
     */
    //given: usedUserPoint = existinguserPoint - userPointRequest
    UserPoint existinguserPoint = new UserPoint(1L, 500L, System.currentTimeMillis());
    UserPoint usedUserPoint = new UserPoint(1L, 100L, System.currentTimeMillis());

    UserPointRequest userPointRequest = UserPointRequest.builder()
        .id(1L)
        .point(400L)
        .build();

    given(userPointRepository.findById(anyLong()))
        .willReturn(existinguserPoint);

    given(userPointRepository.save(any(UserPointRequest.class)))
        .willReturn(usedUserPoint);

    //when: 포인트 사용 서비스 호출
    UserPoint resultUserPoint = pointService.use(userPointRequest);

    //then: 결과 값 검증
    assertThat(resultUserPoint.id())
        .isNotNull()
        .isEqualTo(userPointRequest.getId());
    assertThat(resultUserPoint.point())
        .isNotNull()
        .isEqualTo(existinguserPoint.point() - userPointRequest.getPoint());
  }
}
