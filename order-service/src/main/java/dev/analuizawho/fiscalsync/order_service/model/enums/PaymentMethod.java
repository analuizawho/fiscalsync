package dev.analuizawho.fiscalsync.order_service.model.enums;

import java.util.Set;

public enum PaymentMethod {
    PIX,
    CREDIT_CARD,
    DEBIT_CARD,
    CASH;

    public static final Set<PaymentMethod> ALL_PAYMENT_METHODS = Set.of(
            PaymentMethod.PIX,
            PaymentMethod.CREDIT_CARD,
            PaymentMethod.DEBIT_CARD,
            PaymentMethod.CASH
    );
}
