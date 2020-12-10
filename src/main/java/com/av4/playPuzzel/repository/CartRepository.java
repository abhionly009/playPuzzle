package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.av4.playPuzzel.model.Cart;
import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.model.UserInfo;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("select c from Cart c where c.userInfo = :userInfo")
	public List<Cart> findCartByAuthToken(@Param(value = "userInfo") UserInfo userInfo);
	
	@Modifying
	@Transactional
	@Query("delete from Cart c where c.userInfo = :userInfo and c.product = :product")
	public int deleteItem(@Param(value = "userInfo") UserInfo userInfo,@Param(value = "product") Product product);
	
}
