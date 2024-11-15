package com.petshopspring.petshop.dtos;

import org.springframework.beans.BeanUtils;

import com.petshopspring.petshop.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class ProductDto {

	private Long id;
	
	@NotBlank(message = "O nome não pode estar em branco.")
	private String name;
	
	@NotNull(message = "O preço não pode ser nulo.")
	@Positive(message = "O preço deve ser um valor positivo.")
	private Double price;
	
	/*
	serve para converter uma entidade (Product) para um DTO (ProductDto), 
	facilitando o transporte ou apresentação de dados. 
	Ele é útil quando você tem uma entidade carregada do banco de dados e precisa
	 transformá-la em um DTO para enviá-la como resposta, sem expor diretamente a entidade. 
	*/
	public ProductDto(Product entity) {
		BeanUtils.copyProperties(entity, this);
	}
	
	public ProductDto() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
}
