package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getAllProduct(){
		return productRepo.findAll();
	}

	public List<Product> getProductByCategory(Long category){
		
		return productRepo.getProductByCategoryId( category);
	}
	
	public long findCount() {
		return productRepo.count();
	}
}
