package fastcartRegistration.service;

import org.springframework.stereotype.Service;

import fastcartRegistration.entity.Product;
import fastcartRegistration.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.orElse(null);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}