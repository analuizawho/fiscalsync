package dev.analuizawho.fiscalsync.order_service.exception;

public class CustomersOrdersNotFoundException extends RuntimeException {
    public CustomersOrdersNotFoundException(String message) {
        super(message);
    }
}
