package com.petshopspring.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopspring.petshop.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	
	
}
