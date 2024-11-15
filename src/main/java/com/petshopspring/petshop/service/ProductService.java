package com.petshopspring.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopspring.petshop.entities.Product;
import com.petshopspring.petshop.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		
		productRepository.save(product);
		
		return product;
		
	}
	
	
	
}
