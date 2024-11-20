package com.petshopspring.petshop.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.petshopspring.petshop.dtos.ItemSaleDTO;
import com.petshopspring.petshop.dtos.SaleDTO;
import com.petshopspring.petshop.entities.ItemSale;
import com.petshopspring.petshop.entities.Product;
import com.petshopspring.petshop.entities.Sale;
import com.petshopspring.petshop.repositories.ProductRepository;
import com.petshopspring.petshop.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public SaleDTO addItemToSale(SaleDTO saleDTO) {
	
		Sale sale = new Sale();
		sale.setNameClient(saleDTO.getNameClient());
	
		
		for(ItemSaleDTO item : saleDTO.getItens()) {
			
			ItemSale itemSale = new ItemSale();
			itemSale.setSale(sale);// o item venda associa agora a nova venda
			Optional<Product> productOpt = productRepository.findById(item.getProductId());
			if(productOpt.isEmpty()) {
				throw new ResourceNotFoundException("product not found ");
			}
			Product product = productOpt.get();
			itemSale.setProduct(product);
			itemSale.setQuantity(item.getQuantity());
			sale.addItemToSale(itemSale);
		}
		
		saleRepository.save(sale);
	
		return saleDTO;
	}
	
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String message) {
			super(message);
		}
	}
	
}
