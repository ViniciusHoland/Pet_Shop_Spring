package com.petshopspring.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopspring.petshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
