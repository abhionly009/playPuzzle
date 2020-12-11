package com.av4.playPuzzel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Address;
import com.av4.playPuzzel.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepo;

	public List<Address> saveAddress(Address address) {
		ArrayList<Address> addressList = new ArrayList<Address>();
		Address returnAddress = addressRepo.save(address);
		 addressList.add(returnAddress);
		 return addressList;
	}
}
