package com.av4.playPuzzel.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Name;
import com.av4.playPuzzel.repository.NameRepository;

@Service
public class NameService {

	@Autowired
	NameRepository nameRepo;
	
	public List<Name> getAllName() {
		
				
				List<Name> list = nameRepo.getUserInfo();
				
	Iterator<Name> iter = list.iterator();
	
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
				
				return list;
	}
	
}
