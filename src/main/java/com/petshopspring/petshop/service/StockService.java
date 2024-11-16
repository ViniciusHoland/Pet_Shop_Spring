package com.petshopspring.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.petshopspring.petshop.dtos.ItemStockDto;
import com.petshopspring.petshop.entities.ItemStock;
import com.petshopspring.petshop.entities.Product;
import com.petshopspring.petshop.entities.Stock;
import com.petshopspring.petshop.repositories.ProductRepository;
import com.petshopspring.petshop.repositories.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Long stockId, ItemStockDto itemStockDto) {
		// pego o stock no caso sempre o mesmo pelo id ZERO - que configurei no importSQL
		 Optional<Stock> stockOpt = stockRepository.findById(stockId);
	        if (stockOpt.isEmpty()) {
	            throw new ResourceNotFoundException("Estoque não encontrado!");
	        }

	    Stock stock = stockOpt.get();
	    
		// pego o produto passando o id no corpo da requisição
		Optional<Product> productOpt = productRepository.findById(itemStockDto.getProductId());
		if (productOpt.isEmpty()) {
			throw new ResourceNotFoundException("Produto não encontrado!");
		}

		Product product = productOpt.get();

		ItemStock itemStock = new ItemStock();
		itemStock.setStock(stock);
		// meu item estoque tem um atributo Stock e toda vez que vou adicionar algo no
		// estoque
		// eu procuro primeiro o estoque pelo o id, no caso sempre o mesmo e coloco o
		// produto e quantidad
		// no item estoque. depois o stock vai adicionar o itemestoque na lista e depois
		// vai chamar o
		// repository para salvar no banco
		itemStock.setProduct(product);
		itemStock.setQuantity(itemStockDto.getQuantity());

		stock.addItem(itemStock);
		stockRepository.save(stock);

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String message) {
			super(message);
		}
	}

}