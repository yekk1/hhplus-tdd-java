package io.hhplus.tdd.infra;

import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.domain.point.repository.UserPointRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserPointRepositoryImpl implements UserPointRepository {

  @Override
  public UserPoint save(long id, long point, long updateMillis) {
    return null;
  }

  @Override
  public UserPoint findById(long id) {
    return null;
  }
}
