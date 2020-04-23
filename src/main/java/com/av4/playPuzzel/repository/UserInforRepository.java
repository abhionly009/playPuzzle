package com.av4.playPuzzel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.UserInfo;

@Repository
public interface UserInforRepository extends CrudRepository<UserInfo, Long> {

	@Query("select u from UserInfo u where u.email = :email")
	public UserInfo findUserByEmail(@Param(value = "email") String email);

	@Query("select u from UserInfo u where u.mobile = :mobile")
	public UserInfo findUserByMobile(@Param(value = "mobile") String mobile);

	@Query("Select u from UserInfo u where u.email = :email AND u.password = :password")
	public UserInfo findUserByEmailAndPassword(@Param(value = "email") String email,
			@Param(value = "password") String password);
	
	
	@Query("select u from UserInfo u where u.uId=:uId")
	public UserInfo getUserInfoById(@Param(value="uId") Long uId);
}
