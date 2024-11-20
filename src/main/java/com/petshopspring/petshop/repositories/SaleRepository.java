package com.petshopspring.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopspring.petshop.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
