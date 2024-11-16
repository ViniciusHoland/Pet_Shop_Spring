package com.petshopspring.petshop.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	 @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemStock> itens = new ArrayList<ItemStock>();


	public Stock() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ItemStock> getItens() {
		return itens;
	}


	public void setItens(List<ItemStock> itens) {
		this.itens = itens;
	}
	
	 public void addItem(ItemStock item) {
	        item.setStock(this);
	        this.itens.add(item);
	    }

	 
	
	
}
