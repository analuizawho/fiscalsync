package dev.analuizawho.fiscalsync.order_service;

import dev.analuizawho.fiscalsync.order_service.mapper.OrderMapper;
import dev.analuizawho.fiscalsync.order_service.repository.OrderRepository;
import dev.analuizawho.fiscalsync.order_service.service.OrderService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    OrderMapper orderMapper;

    @InjectMocks
    OrderService orderService;
}
