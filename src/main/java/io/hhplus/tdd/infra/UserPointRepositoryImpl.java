package io.hhplus.tdd.infra;

import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.domain.point.UserPoint;
import io.hhplus.tdd.domain.point.repository.UserPointRepository;
import io.hhplus.tdd.domain.point.service.request.UserPointRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPointRepositoryImpl implements UserPointRepository {

  private final UserPointTable userPointTable;
  @Override
  public UserPoint save(UserPointRequest userPointRequest) {
    return userPointTable.insertOrUpdate(userPointRequest.getId(), userPointRequest.getPoint());
  }

  @Override
  public UserPoint findById(long id) {
    return userPointTable.selectById(id);
  }
}
