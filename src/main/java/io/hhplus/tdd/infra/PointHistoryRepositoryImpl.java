package io.hhplus.tdd.infra;

import io.hhplus.tdd.database.PointHistoryTable;
import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.repository.PointHistoryRepository;
import io.hhplus.tdd.domain.point.service.request.PointHistoryRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointHistoryRepositoryImpl implements PointHistoryRepository {

  private PointHistoryTable pointHistoryTable;

  @Override
  public PointHistory save(PointHistoryRequest pointHistoryRequest) {
    return pointHistoryTable.insert(pointHistoryRequest.getUserId(), pointHistoryRequest.getAmount(), pointHistoryRequest.getType(), pointHistoryRequest.getUpdateMillis());
  }

  @Override
  public List<PointHistory> findById(long userId) {
    return pointHistoryTable.selectAllByUserId(userId);
  }
}
