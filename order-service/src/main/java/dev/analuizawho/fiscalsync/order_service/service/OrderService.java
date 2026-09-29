package dev.analuizawho.fiscalsync.order_service.service;

import dev.analuizawho.fiscalsync.order_service.dto.OrderRequest;
import dev.analuizawho.fiscalsync.order_service.dto.OrderRequestUpdate;
import dev.analuizawho.fiscalsync.order_service.dto.OrderResponse;
import dev.analuizawho.fiscalsync.order_service.exception.CustomersOrdersNotFoundException;
import dev.analuizawho.fiscalsync.order_service.exception.InvalidRequestException;
import dev.analuizawho.fiscalsync.order_service.exception.OrderNotFoundException;
import dev.analuizawho.fiscalsync.order_service.mapper.OrderMapper;
import dev.analuizawho.fiscalsync.order_service.model.OrderEntity;
import dev.analuizawho.fiscalsync.order_service.model.enums.PaymentMethod;
import dev.analuizawho.fiscalsync.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderMapper mapper;

    public OrderService(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public OrderResponse create(OrderRequest orderRequest) {
        var orderEntity = mapper.toEntity(orderRequest);

        validatePaymentMethod(orderRequest.paymentMethod());
        repository.save(orderEntity);
        return mapper.toResponse(orderEntity);
    }

    // regra de negócio (um client pode ter uma ou mais orders)
    @Transactional(readOnly = true)
    public List<OrderResponse> findById(UUID id){
        var orderEntities = getCustomersOrdersOrThrow(id);
        return mapper.toResponseList(orderEntities);
    }

    @Transactional
    public OrderResponse update(UUID id, OrderRequestUpdate orderUpdate){
        var orderEntity = getOrderOrThrow(id);
        validatePaymentMethod(orderUpdate.paymentMethod());
        orderEntity.update(orderUpdate);
        repository.save(orderEntity);
        return mapper.toResponse(orderEntity);
    }

    @Transactional
    public void softDelete(UUID id){
        var orderEntity = getOrderOrThrow(id);
        orderEntity.setActive(false);
        repository.save(orderEntity);
    }

    @Transactional
    public void activate(UUID id){
        var orderEntity = getOrderOrThrow(id);
        orderEntity.setActive(true);
        repository.save(orderEntity);
    }

    private void validatePaymentMethod(PaymentMethod paymentMethod) {
        if (!PaymentMethod.ALL_PAYMENT_METHODS.contains(paymentMethod)) {
            throw new InvalidRequestException("Payment method must be one of the following: "
                    + PaymentMethod.ALL_PAYMENT_METHODS);
        }
    }

    private OrderEntity getOrderOrThrow(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found with id: " + id));
    }

    private List<OrderEntity> getCustomersOrdersOrThrow(UUID id) {
        return repository.findByCustomerId(id)
                .orElseThrow(() ->
                        new CustomersOrdersNotFoundException("Orders not found with customer id: " + id));
    }
}
