package dev.analuizawho.fiscalsync.order_service.dto;

import dev.analuizawho.fiscalsync.order_service.model.OrderItemEntity;
import dev.analuizawho.fiscalsync.order_service.model.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderRequest(
        @NotNull
        UUID customerId,
        @NotNull
        BigDecimal totalAmount,
        @NotNull
        PaymentMethod paymentMethod,
        @NotBlank
        String shippingAddress,
        @NotEmpty
        List<OrderItemEntity> items
) {
}
