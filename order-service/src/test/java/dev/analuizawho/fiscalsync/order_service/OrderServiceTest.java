package dev.analuizawho.fiscalsync.order_service;

import dev.analuizawho.fiscalsync.order_service.mapper.OrderMapper;
import dev.analuizawho.fiscalsync.order_service.repository.OrderRepository;
import dev.analuizawho.fiscalsync.order_service.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository repository;

    @Mock
    OrderMapper mapper;

    @InjectMocks
    OrderService orderService;

    @Test
    void shouldCreateOrder(){

    }

    @Test
    void shouldFindOrdersById() {

    }

    @Test
    void shouldUpdateOrder() {

    }

    @Test
    void shouldSoftDeleteOrder() {

    }

    @Test
    void shouldActivateOrder() {

    }

    @Test
    void shouldThrowOrderNotFoundException() {

    }

    @Test
    void shouldThrowCustomersOrdersNotFoundException() {

    }

    @Test
    void shouldValidatePaymentMethod() {

    }
}
