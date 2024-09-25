package io.hhplus.tdd.domain.point.repository;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.TransactionType;
import java.util.List;

public interface PointHistoryRepository {
  PointHistory save(long userId, long amount, TransactionType type, long updateMillis);

  List<PointHistory> findById(long userId);
}
