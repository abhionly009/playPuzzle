package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Address;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.service.AddressService;
import com.av4.playPuzzel.service.UserService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public List<Address> createAddress(@RequestBody Address address, @Param(value="authToken")String authToken){
		
		UserInfo userInfo = userService.findUserByAuthToken(authToken);	

		address.setUserInfo(userInfo);
		
		System.out.println("AAAAAAA     "+address);
return 	addressService.saveAddress(address);


	}
	
}
