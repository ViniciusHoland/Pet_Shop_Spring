package com.petshopspring.petshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemStockDto {

	@NotNull
	private Long productId;
	
	@Positive(message = "A quantidade deve ser um número positivo.")
	private int quantity;
	

	public ItemStockDto() {

	}

	public ItemStockDto(Long productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
