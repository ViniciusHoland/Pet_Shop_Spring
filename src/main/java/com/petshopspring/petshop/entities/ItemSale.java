package com.petshopspring.petshop.entities;

import org.springframework.beans.factory.annotation.Autowired;

import com.petshopspring.petshop.repositories.ProductRepository;
import com.petshopspring.petshop.service.ProductService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemSale {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "venda_id", nullable = false)
	private Sale sale; // Venda associada a este item

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Product product; // Produto associado a este item

	@Column(nullable = false)
	private Double totalItem = 0.0;
	
	
	public ItemSale() {
		super();
	}

	public ItemSale(Integer quantity, Sale sale, Product product) {
		super();
		this.quantity = quantity;
		this.sale = sale;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		this.calculedItem();
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}

	public Double calculedItem() {
		
		return this.totalItem =  this.getProduct().getPrice() * this.quantity;
		
	}
	


}
