package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av4.playPuzzel.model.City;
import com.av4.playPuzzel.service.CitySevice;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CitySevice  cityService;
	

	@PostMapping("/create")
	public City createCity(@RequestBody City city) {

		return cityService.saveCity(city);
	}
	
	
	@GetMapping("/get")
	public List<City> getAllCity(){
		
		
		
		return cityService.getCity();
	}
	
}
