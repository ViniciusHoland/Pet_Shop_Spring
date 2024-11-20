package com.petshopspring.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopspring.petshop.dtos.ItemSaleDTO;
import com.petshopspring.petshop.dtos.SaleDTO;
import com.petshopspring.petshop.service.SaleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@PostMapping("/add")
	public ResponseEntity<SaleDTO> addItemToSale(@Valid @RequestBody SaleDTO saleDTO) {
		
		SaleDTO result =  saleService.addItemToSale(saleDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
