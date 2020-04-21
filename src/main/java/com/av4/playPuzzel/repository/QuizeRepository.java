package com.av4.playPuzzel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Quize;

@Repository
public interface QuizeRepository extends JpaRepository<Quize, Long> {
	
	@Query("select q from Quize q where q.name = :name")
	public Quize findQuizeByName(@Param(value = "name") String name);

}
