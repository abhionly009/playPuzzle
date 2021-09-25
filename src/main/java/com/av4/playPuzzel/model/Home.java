package com.av4.playPuzzel.model;

import java.util.List;

public class Home {
	
	private UserInfo userInfo;
	
	private List<Product> cart;
	
	private List<Product> productList;
	
	

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
	
	

}
