package com.petshopspring.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopspring.petshop.dtos.ItemStockDto;
import com.petshopspring.petshop.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@PostMapping("/{stockId}/add")
	public ResponseEntity<String> addProductToStock(@PathVariable Long stockId,
			@RequestBody ItemStockDto itemStockDto){
		stockService.addProduct(stockId, itemStockDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Sucessfull");
	}
	
}
