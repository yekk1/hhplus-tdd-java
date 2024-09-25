package io.hhplus.tdd.domain.point.service;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.infra.PointHistoryRepositoryImpl;
import io.hhplus.tdd.infra.UserPointRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{
  private final UserPointRepositoryImpl userPointRepository;
  private final PointHistoryRepositoryImpl pointHistoryRepository;
  @Override
  public UserPoint point(long userId) {
    return null;
  }
  public List<PointHistory> history(long UserId) {
    return null;
  }
  public UserPoint charge(long UserId, long amount) {
    return null;
  }

  public UserPoint use(long UserId, long amount) {
    return null;
  }
}
