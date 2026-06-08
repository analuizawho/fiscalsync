package dev.analuizawho.fiscalsync.order_service.repository;

import dev.analuizawho.fiscalsync.order_service.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
