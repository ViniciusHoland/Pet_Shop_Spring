package com.petshopspring.petshop.dtos;


public class ItemStockDto {

	private Long productId;
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
