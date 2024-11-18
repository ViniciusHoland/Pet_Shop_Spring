package com.petshopspring.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopspring.petshop.dtos.ItemStockDto;
import com.petshopspring.petshop.entities.ItemStock;
import com.petshopspring.petshop.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@PostMapping("/{stockId}/add")
	public ResponseEntity<String> addProductToStock(@PathVariable Long stockId,
			 @Valid @RequestBody ItemStockDto itemStockDto){
		stockService.addProduct(stockId, itemStockDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Successful");
	}
	
	
	@GetMapping
	public ResponseEntity<List<ItemStockDto>> getAllProducts(){
		
		List<ItemStockDto> list = stockService.getAllProducts();
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@DeleteMapping("/{stockId}/delete")
	public ResponseEntity<ItemStockDto> deleteProduct(@PathVariable Long stockId,
			 @Valid @RequestBody ItemStock idItemStock){
		
		
		Long idItem = idItemStock.getId();
		ItemStockDto dto = stockService.deleteItemStock(stockId, idItem);
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
		
	}
	
	
	
}
