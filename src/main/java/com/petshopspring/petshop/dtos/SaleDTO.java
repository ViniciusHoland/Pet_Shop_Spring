package com.petshopspring.petshop.dtos;

import java.util.List;

public class SaleDTO {
	
	
	private String nameClient;
	private List<ItemSaleDTO> itens;

	
	public SaleDTO() {
		super();
	}

	public SaleDTO(String nameClient, List<ItemSaleDTO> itens) {
		super();
		this.itens = itens;
		this.nameClient = nameClient;
	}
	
	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public List<ItemSaleDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemSaleDTO> itens) {
		this.itens = itens;
	}
	
	
}
