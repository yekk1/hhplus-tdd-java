package io.hhplus.tdd.domain.point.service;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.TransactionType;
import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.infra.PointHistoryRepositoryImpl;
import io.hhplus.tdd.infra.UserPointRepositoryImpl;
import io.hhplus.tdd.domain.point.service.request.PointHistoryRequest;
import io.hhplus.tdd.domain.point.service.request.UserPointRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{
  private final UserPointRepositoryImpl userPointRepository;
  private final PointHistoryRepositoryImpl pointHistoryRepository;
  @Override
  public UserPoint point(long userId) {
    return userPointRepository.findById(userId);
  }

  @Override
  public List<PointHistory> history(long UserId) {
    return pointHistoryRepository.findById(UserId);
  }

  @Override
  public UserPoint charge(UserPointRequest userPointRequest) {
    // 기존 포인트 정보 확인 후 포인트 정보 기록
    UserPoint userpointRlt = userPointRepository.findById(userPointRequest.getId());
    UserPoint userPoint = userPointRepository.save(userPointRequest.chargePoint(userpointRlt.point()));

    // 포인트 내역 기록
    PointHistoryRequest pointHistoryRequest = PointHistoryRequest.builder()
        .userId(userPoint.id())
        .amount(userPointRequest.getPoint())
        .type(TransactionType.CHARGE)
        .updateMillis(userPoint.updateMillis())
        .build();
    PointHistory pointHistory = pointHistoryRepository.save(pointHistoryRequest);

    return userPoint;
  }
  public UserPoint use(UserPointRequest userPointRequest) {
    // 기존 포인트 정보 확인 후 포인트 정보 기록
    UserPoint userpointRlt = userPointRepository.findById(userPointRequest.getId());
    UserPoint userPoint = userPointRepository.save(userPointRequest.usePoint(userpointRlt.point()));

    // 포인트 내역 기록
    PointHistoryRequest pointHistoryRequest = PointHistoryRequest.builder()
        .userId(userPoint.id())
        .amount(userPointRequest.getPoint())
        .type(TransactionType.CHARGE)
        .updateMillis(userPoint.updateMillis())
        .build();
    PointHistory pointHistory = pointHistoryRepository.save(pointHistoryRequest);

    return userPoint;
  }
}
