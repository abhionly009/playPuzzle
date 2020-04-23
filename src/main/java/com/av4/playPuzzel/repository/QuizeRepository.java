package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.Quize;
import com.av4.playPuzzel.model.UserInfo;

@Repository
public interface QuizeRepository extends JpaRepository<Quize, Long> {
	
	@Query("select q from Quize q where q.name = :name")
	public Quize findQuizeByName(@Param(value = "name") String name);
	
	@Query("select q from Quize q where q.userInfo = :userInfo")
	public Quize findEnrolledQuizeByUserId(@Param(value = "userInfo") UserInfo userInfo);
	
	@Query("update Quize q set q.userInfo=:uId where q.id=:id")
	public Quize enrollUser( @Param(value="uId") Long uId,@Param(value="id") Long id);

}
