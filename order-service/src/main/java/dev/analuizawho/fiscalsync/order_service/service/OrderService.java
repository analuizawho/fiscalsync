package dev.analuizawho.fiscalsync.order_service.service;

import dev.analuizawho.fiscalsync.order_service.dto.OrderRequest;
import dev.analuizawho.fiscalsync.order_service.dto.OrderRequestUpdate;
import dev.analuizawho.fiscalsync.order_service.dto.OrderResponse;
import dev.analuizawho.fiscalsync.order_service.mapper.OrderMapper;
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
        repository.save(orderEntity);
        return mapper.toResponse(orderEntity);
    }

    // regra de negócio (um client pode ter uma ou mais orders)
    @Transactional(readOnly = true)
    public List<OrderResponse> findById(UUID id){
        var orderEntity = repository.getReferenceById(id);
        return mapper.toResponseList(orderEntity);
    }

    @Transactional
    public OrderResponse update(UUID id, OrderRequestUpdate orderUpdate){
        var orderEntity = repository.getReferenceById(id);
        orderEntity.update(orderUpdate);
        repository.save(orderEntity);
        return mapper.toResponse(orderEntity);
    }

    @Transactional
    public void softDelete(UUID id){
        var orderEntity = repository.getReferenceById(id);
        orderEntity.setActive(false);
        repository.save(orderEntity);
    }

    @Transactional
    public void activate(UUID id){
        var orderEntity = repository.getReferenceById(id);
        orderEntity.setActive(true);
        repository.save(orderEntity);
    }
}
