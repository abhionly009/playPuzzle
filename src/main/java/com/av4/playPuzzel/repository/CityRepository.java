package com.av4.playPuzzel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.av4.playPuzzel.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
