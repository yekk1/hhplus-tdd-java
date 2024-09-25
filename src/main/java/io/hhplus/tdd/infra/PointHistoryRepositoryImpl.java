package io.hhplus.tdd.infra;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.TransactionType;
import io.hhplus.tdd.domain.point.repository.PointHistoryRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PointHistoryRepositoryImpl implements PointHistoryRepository {

  @Override
  public PointHistory save(long userId, long amount, TransactionType type, long updateMillis) {
    return null;
  }

  @Override
  public List<PointHistory> findById(long userId) {
    return null;
  }
}
