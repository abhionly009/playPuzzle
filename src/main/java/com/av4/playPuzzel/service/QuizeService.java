package com.av4.playPuzzel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Quize;
import com.av4.playPuzzel.repository.QuizeRepository;

@Service
public class QuizeService {
	
	@Autowired
	QuizeRepository quizeRepository;
	
	public Quize createQuize(Quize quize) {
		
		return quizeRepository.save(quize);
	}

	public Quize getQuize(String name) {
		
		return quizeRepository.findQuizeByName(name);
	}
}
