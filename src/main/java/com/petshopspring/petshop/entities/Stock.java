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
	
	 // A anotação @OneToMany indica um relacionamento de um-para-muitos entre Stock e ItemStock
    // Isso significa que um 'Stock' pode ter vários 'ItemStock', e cada 'ItemStock' estará associado a um único 'Stock'
    // @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    // O campo 'mappedBy' é usado para indicar que o mapeamento do relacionamento já é feito pela classe ItemStock
    // 'cascade = CascadeType.ALL' faz com que todas as operações (persistir, atualizar, remover) realizadas no Stock também sejam propagadas para os ItemStock associados
    // 'orphanRemoval = true' garante que, caso um ItemStock seja removido da lista de itens de Stock, ele também será removido do banco de dados.
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
