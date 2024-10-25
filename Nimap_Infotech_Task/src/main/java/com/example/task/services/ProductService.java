package com.example.task.services;

import com.example.task.Entities.Product;
import com.example.task.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(int page) {
		return productRepository.findAll(PageRequest.of(page, 10)); 
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product updateProduct(Long id, Product product) {
		product.setId(id); 
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
