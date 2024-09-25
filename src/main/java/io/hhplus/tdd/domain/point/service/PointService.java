package io.hhplus.tdd.domain.point.service;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.UserPoint;
import java.util.List;

public interface PointService {
  public UserPoint point(long userId) ;

  public List<PointHistory> history(long UserId) ;

  public UserPoint charge(long UserId, long amount) ;

  public UserPoint use(long UserId, long amount) ;
}
