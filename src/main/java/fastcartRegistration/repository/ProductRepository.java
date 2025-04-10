package fastcartRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fastcartRegistration.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
