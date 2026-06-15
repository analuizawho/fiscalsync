package dev.analuizawho.fiscalsync.order_service.dto;

import dev.analuizawho.fiscalsync.order_service.model.enums.PaymentMethod;
import dev.analuizawho.fiscalsync.order_service.model.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID customerId,
        BigDecimal totalAmount,
        Status status,
        PaymentMethod paymentMethod,
        String shippingAddress,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
