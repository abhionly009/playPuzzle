package com.av4.playPuzzel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.InitialInfo;
import com.av4.playPuzzel.service.CategoryService;
import com.av4.playPuzzel.service.CitySevice;
import com.av4.playPuzzel.service.ProductService;
import com.av4.playPuzzel.service.UserService;


@RestController
@RequestMapping("api/home")
public class HomeController  {
	
	@Autowired
	CategoryService catService;
	
	@Autowired 
	ProductService proService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CitySevice cityService;
	
	

	@GetMapping("/data")
	
	public List<InitialInfo> getHomeData() {
		
		InitialInfo info = null;
		List<InitialInfo> list = new ArrayList<InitialInfo>();
		
		info = new InitialInfo("user",userService.getAllUser());
		list.add(info);
		
		info = new InitialInfo("product", proService.findCount());
		list.add(info);
		info = new InitialInfo("category", catService.getCategoryCount());
		
		list.add(info);
		
		info = new InitialInfo ("city",cityService.cityCount() );
		list.add(info);

			
		return list;
	}
	
}
