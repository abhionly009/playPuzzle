package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Cart;
import com.av4.playPuzzel.model.CartRequest;
import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.service.CartService;
import com.av4.playPuzzel.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addItems")
	public String addProductToCart(@RequestBody CartRequest cartRequest, @Param(value="authToken")String authToken ) {
		
		
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);
		Cart cart = new Cart();
		
		if (userInfo!= null) {
			cart.setProduct(cartRequest.getProduct());
			cart.setUserInfo(userInfo);
			
			
			return cartService.addProduct(cart);
			
		}else {
			return "Please login first to add product to cart";
		}

	}
	
	@GetMapping("/itemList")
	public List<Product> getCartItems(@Param(value="authToken") String authToken){
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);

		return cartService.getAllProduct(userInfo);
	}
	
	
	@GetMapping("/deleteItem")
	public String deletItemFromCart(@RequestBody CartRequest cartRequest,@Param(value="authToken") String authToken ) {
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);
		
		int result = cartService.deteleItem(userInfo,cartRequest.getProduct());
		
		if (result >0) {
			return "Item has been removed from Cart";
		}else {
			return "Something went wrong";
		}
		
	}
	
}
