package io.hhplus.tdd.domain.point.repository;

import io.hhplus.tdd.domain.point.PointHistory;
import io.hhplus.tdd.domain.point.service.request.PointHistoryRequest;
import java.util.List;

public interface PointHistoryRepository {
  PointHistory save(PointHistoryRequest pointHistoryRequest);

  List<PointHistory> findById(long userId);
}
