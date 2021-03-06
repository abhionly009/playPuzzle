package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query("select c from Category c where c.id=:id")
	public Category getCategoryById(@Param(value="id") Long id);
	

}
