package io.hhplus.tdd.domain.point.repository;

import io.hhplus.tdd.domain.point.UserPoint;

public interface UserPointRepository {
  UserPoint save(long id, long point, long updateMillis);

  UserPoint findById(long id);
}
