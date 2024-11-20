package com.petshopspring.petshop.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemSale> itens = new ArrayList<ItemSale>();

	@Column(nullable = false)
	private Double totalSale = 0.0;
	
	@Column(nullable = false)
	private String nameClient;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemSale> getItens() {
		return itens;
	}

	public void setItens(List<ItemSale> itens) {
		this.itens = itens;
	}
	
	public Double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(Double totalSale) {
		this.totalSale = totalSale;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public void addItemToSale(ItemSale itemSale) {
		itemSale.setSale(this); // Configura a venda atual no item
		this.itens.add(itemSale);
		this.totalSale += itemSale.getTotalItem();
	}
	
}
