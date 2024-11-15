package com.petshopspring.petshop.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopspring.petshop.dtos.ProductDto;
import com.petshopspring.petshop.entities.Product;
import com.petshopspring.petshop.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
		
		System.out.println("Name: " + productDto.getName());
		System.out.println("Price: " + productDto.getPrice());
		
		var product = new Product();
		BeanUtils.copyProperties(productDto, product);
		productService.addProduct(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);

	}
	
}


