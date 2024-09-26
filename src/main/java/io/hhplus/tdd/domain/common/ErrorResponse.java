package io.hhplus.tdd.domain.common;

public record ErrorResponse(
        String code,
        String message
) {
}
