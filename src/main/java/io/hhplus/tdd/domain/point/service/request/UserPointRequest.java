package io.hhplus.tdd.domain.point.service.request;

import io.hhplus.tdd.domain.point.UserPoint;
import lombok.Builder;
import lombok.Data;

@Data
public class UserPointRequest {
  private long id;
  private long point;

  @Builder
  public UserPointRequest(long id, long point) {
    this.id = id;
    this.point = point;
  }

  @Builder
  public UserPointRequest(UserPoint userPoint) {
    this.id = userPoint.id();
    this.point = userPoint.point();
  }

  public UserPointRequest toDto() {
    return UserPointRequest.builder()
        .id(this.id)
        .point(this.point)
        .build();
  }

  public UserPointRequest chargePoint(long point) {
    return UserPointRequest.builder()
        .id(this.id)
        .point(point + this.point)
        .build();
  }

  public UserPointRequest usePoint(long point) {
    return UserPointRequest.builder()
        .id(this.id)
        .point(point - this.point)
        .build();
  }
}
