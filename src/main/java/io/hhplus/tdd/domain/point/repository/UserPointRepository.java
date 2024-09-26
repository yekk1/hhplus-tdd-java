package io.hhplus.tdd.domain.point.repository;

import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.domain.point.service.request.UserPointRequest;

public interface UserPointRepository {
  UserPoint save(UserPointRequest userPointRequest);

  UserPoint findById(long id);
}
