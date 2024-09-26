package io.hhplus.tdd.domain.point.service;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.domain.point.service.request.UserPointRequest;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PointService {
  public UserPoint point(long userId) ;

  public List<PointHistory> history(long UserId) ;

  public UserPoint charge(UserPointRequest userPointRequest) ;

  public UserPoint use(UserPointRequest userPointRequest) ;
}
