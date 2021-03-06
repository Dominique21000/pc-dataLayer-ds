package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Iterable<Product>getProducts() {
		return productRepository.findAll();		
	}
	
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Iterable<Product> getProductsByName(String name){
		return productRepository.findByName(name);
	}
	
	public Iterable<Product> getProductsByCategoryName(String name){
		return productRepository.findByCategoriesName(name);
	}
	
	public Iterable<Product> getProductByCostUnder(Integer cost){
		return productRepository.findByCostLessThanNative(cost);
	}
}