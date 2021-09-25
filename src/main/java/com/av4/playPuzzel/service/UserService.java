package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.model.UserInfoWithoutSensibleInfo;
import com.av4.playPuzzel.repository.UserInforRepository;

@Service
public class UserService {

	@Autowired
	UserInforRepository userInforRepository;

	public boolean findUserByEmailId(String email) {
		UserInfo userInfo = userInforRepository.findUserByEmail(email);

		if (userInfo != null)
			return true;
		else
			return false;
	}

	public boolean findUserByMobile(String mobile) {

		UserInfo userInfo = userInforRepository.findUserByMobile(mobile);

		if (userInfo != null)
			return true;
		else
			return false;
	}
	
	public UserInfo saveUserInfo(UserInfo userInfo) {
		return userInforRepository.save(userInfo);
	}
	
	@Transactional
	public int updateProfilePic(String auth, String profilePic) {
		
		return userInforRepository.updateProfile(profilePic,auth);
	}
	
	public UserInfo checkUserCredentials(String email, String pass) {
		
		return userInforRepository.findUserByEmailAndPassword(email,pass);
		
	}
	
	public UserInfo findUserByAuthToken(String authToken) {
		return userInforRepository.findUserByAuthToken(authToken);
	}
	
	public List<UserInfoWithoutSensibleInfo> getUserDetails(){
		
		
		return  userInforRepository.findAllUsers();
	}
	
	public int logoutUserBySettingAuthEnpty(String authToken) {
		
		return userInforRepository.logoutUser(authToken,"");
	}

	public int updateAuthToken(String authToken,String email) {
		return userInforRepository.updateAuthToekn(authToken, email);
	}

	public long getAllUser() {
		return userInforRepository.count();
	}
	
}
