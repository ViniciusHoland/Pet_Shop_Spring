package com.petshopspring.petshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_item_stock")
public class ItemStock {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id do item no estoque

    @ManyToOne
    @JoinColumn(name = "stock_id") // chave estrangeira para o estoque
    private Stock stock; // a que estoque o item pertence
    
    @ManyToOne
    @JoinColumn(name = "product_id") // chave estrangeira para o produto
    private Product product; // o produto no estoque

	private int quantity;
	
	private String name;

	public ItemStock() {
	
	}



	public ItemStock(Stock stock, int quantity, Product product, String name) {
		super();
		this.stock = stock;
		this.quantity = quantity;
		this.product = product;
		this.name = name;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
}
