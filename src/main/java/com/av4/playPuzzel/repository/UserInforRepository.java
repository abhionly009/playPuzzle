package com.av4.playPuzzel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.model.UserInfoWithoutSensibleInfo;

@Repository
public interface UserInforRepository extends CrudRepository<UserInfo, Long> {

	@Query("select u from UserInfo u where u.email = :email")
	public UserInfo findUserByEmail(@Param(value = "email") String email);

	@Query("select u from UserInfo u where u.mobile = :mobile")
	public UserInfo findUserByMobile(@Param(value = "mobile") String mobile);

	@Query("Select u from UserInfo u where u.email = :email AND u.password = :password")
	public UserInfo findUserByEmailAndPassword(@Param(value = "email") String email,
			@Param(value = "password") String password);
	
	@Modifying
	@Query("Update UserInfo u set u.profilePic = :profilePic where u.authToken = :authToken")
	public int updateProfile(@Param(value="profilePic") String profilePic, @Param(value="authToken") String authToken);
	
	@Query("select u from UserInfo u where u.uId=:uId")
	public UserInfo getUserInfoById(@Param(value="uId") Long uId);
	
	@Query("select u from UserInfo u where u.authToken = :authToken")
	public UserInfo findUserByAuthToken(@Param(value = "authToken") String authToken);
	
//	public static final String FIND_USERS_INFO = "SELECT u_id, name, email, mobile, is_email_verified, is_mobile_verified FROM user_info";

	
//	@Query(value = FIND_USERS_INFO, nativeQuery = true)
	@Query("select u from UserInfo u")
	public List<UserInfoWithoutSensibleInfo> findAllUsers();
	
}
