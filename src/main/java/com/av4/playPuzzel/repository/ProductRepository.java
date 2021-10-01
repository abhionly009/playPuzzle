package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Category;
import com.av4.playPuzzel.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.category.id=:category")
	public List<Product> getProductByCategoryId(@Param(value="category") Long category);
	
	@Query("select p from Product p where p.pId=:pId")
	public Product getProductById(@Param(value="pId") Long pId);

	
}
