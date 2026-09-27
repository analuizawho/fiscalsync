package dev.analuizawho.fiscalsync.order_service.dto;

import dev.analuizawho.fiscalsync.order_service.model.OrderItemEntity;
import dev.analuizawho.fiscalsync.order_service.model.enums.PaymentMethod;
import java.math.BigDecimal;
import java.util.List;

public record OrderRequestUpdate(
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String shippingAddress,
        List<OrderItemEntity> items
) {
}
