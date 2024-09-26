package io.hhplus.tdd.domain.point.service.request;

import io.hhplus.tdd.domain.point.TransactionType;
import lombok.Builder;
import lombok.Data;

@Data
public class PointHistoryRequest {
  private long userId;
  private long amount;
  private TransactionType type;
  private long updateMillis;

  @Builder
  public PointHistoryRequest(long userId, long amount, TransactionType type,
      long updateMillis) {
    this.userId = userId;
    this.amount = amount;
    this.type = type;
    this.updateMillis = updateMillis;
  }

}
