package com.petshopspring.petshop.dtos;

import java.util.List;

public class StockDTO {
	
	   private List<ItemStockDto> items; // Lista de itens no estoque

	    public StockDTO() {
	    }

	    public StockDTO(List<ItemStockDto> items) {
	        this.items = items;
	    }

	    public List<ItemStockDto> getItems() {
	        return items;
	    }

	    public void setItems(List<ItemStockDto> items) {
	        this.items = items;
	    }
}
