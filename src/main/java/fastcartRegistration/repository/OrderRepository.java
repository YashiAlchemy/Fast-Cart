package fastcartRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fastcartRegistration.entity.Order;
import fastcartRegistration.entity.OrderItem;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(Long userId);
}


