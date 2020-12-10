package com.av4.playPuzzel.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Cart;
import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	

	
	public String addProduct(Cart cart) {
		cartRepository.save(cart);
		return "Product added to cart successfully";
	}
	
	
	public List<Product> getAllProduct(UserInfo userInfo){
	List<Cart> cartList =	cartRepository.findCartByAuthToken(userInfo);
	
	Iterator<Cart> cartIterator = cartList.iterator();
	
	List<Product> productList = new ArrayList<Product>();
	
	while (cartIterator.hasNext()) {
		Cart cart = cartIterator.next();
		
			productList.add(cart.getProduct());		
		
	}
		
	return productList;
		
	}
	
	public int deteleItem(UserInfo userInfo, Product product ) {
		
		
		int status = cartRepository.deleteItem(userInfo, product);
		System.out.println("State is............." + status);
		return status;
		
	}
}
