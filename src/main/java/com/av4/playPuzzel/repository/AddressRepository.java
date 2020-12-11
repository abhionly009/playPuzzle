package com.av4.playPuzzel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
