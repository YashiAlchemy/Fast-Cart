package fastcartRegistration.service;

import java.util.List;

import fastcartRegistration.entity.Product;

public interface ProductService {
	Product saveProduct(Product product); // <- must match exactly

	List<Product> getAllProducts();

	Product getProductById(Long id);

	void deleteProduct(Long id);
}
