package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Name;
import com.av4.playPuzzel.service.NameService;

@RestController
@RequestMapping("/name")
public class NameController {


	@Autowired
	NameService nameService;
	
	@GetMapping("/all")
	public List<Name> getAllName(){
		
				
		 return nameService.getAllName();
	}
	
}
