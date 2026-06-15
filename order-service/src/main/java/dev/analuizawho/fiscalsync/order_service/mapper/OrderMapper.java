package dev.analuizawho.fiscalsync.order_service.mapper;

import dev.analuizawho.fiscalsync.order_service.dto.OrderRequest;
import dev.analuizawho.fiscalsync.order_service.dto.OrderResponse;
import dev.analuizawho.fiscalsync.order_service.model.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(OrderRequest orderRequest);

    OrderResponse toResponse(OrderEntity orderEntity);

    List<OrderResponse> toResponseList(OrderEntity orderEntity);
}
