package dev.vorstu.repositories;


import dev.vorstu.enitity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItemRepository extends JpaRepository<OrderItem, Long> {
}
