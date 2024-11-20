package com.petshopspring.petshop.dtos;

import org.springframework.beans.BeanUtils;

import com.petshopspring.petshop.entities.ItemSale;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemSaleDTO {
	
	//private Long saleId;
	
	@NotNull
	private Long productId;
	
	@Positive(message = "A quantidade deve ser um número positivo.")
	private Integer quantity;
	
	public ItemSaleDTO() {
		super();
	}

	public ItemSaleDTO(ItemSale itemSale) {
		BeanUtils.copyProperties(itemSale, this);
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/*public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}*/
	
	
	
	
	
	
}
