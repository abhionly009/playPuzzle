package com.av4.playPuzzel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.Quize;
import com.av4.playPuzzel.service.QuizeService;

@RestController
@RequestMapping("/quize")
public class QuizeController {

	@Autowired
	QuizeService quizeService;
	
	

	@PostMapping("/create")
	public Quize createQuize(@RequestBody Quize quize) {

		return quizeService.createQuize(quize);

	}

	@GetMapping("/getQuize")
	public Quize getQuize(@Param(value = "name") String name) {

		return quizeService.getQuize(name);
		
	}
}
