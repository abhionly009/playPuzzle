package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.City;
import com.av4.playPuzzel.repository.CityRepository;

@Service
public class CitySevice {

	@Autowired
	CityRepository cityRepo;
	
	public List<City> getCity(){
		
		return cityRepo.findAll();
	}

	
	public City saveCity(City city) {
		return cityRepo.save(city);
	}
	
	public long cityCount() {
		return cityRepo.count();
	}
}
