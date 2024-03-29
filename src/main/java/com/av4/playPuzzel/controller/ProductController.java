package com.av4.playPuzzel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Category;
import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.repository.CategoryRepository;
import com.av4.playPuzzel.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {

		
		Category category = categoryRepository.getCategoryById(product.getCategory().getId());
		Product alteredProduct = new Product();
		
		alteredProduct.setName(product.getName());
		alteredProduct.setDescription(product.getDescription());
		alteredProduct.setDiscount(product.getDiscount());
		alteredProduct.setPrice(product.getPrice());
		alteredProduct.setBrand(product.getBrand());
		alteredProduct.setCategory(category);
		alteredProduct.setImageUrl(product.getImageUrl());
		System.err.println(alteredProduct);
		
		return productService.saveProduct(alteredProduct);
	}
	
	@GetMapping("/allProduct")
	public List<Product> getAllProduct(){
		
		ArrayList<Product> products =  (ArrayList<Product>) productService.getAllProduct();
		return products;
		
	}
	
	@GetMapping("/productByCategory")
	public List<Product> getProductByCategory(@Param(value = "cId") Long cId){
		System.out.println(cId);
		
		return productService.getProductByCategory(cId);
		
	}
	
	
	@GetMapping("/productById")
	public Product getProductById(@Param(value="pId") Long pId) {
		return productService.getProductById(pId);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		
		System.out.println(product);
		return null;
	}
	
	
}
