package fastcartRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fastcartRegistration.entity.Order;
import fastcartRegistration.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
