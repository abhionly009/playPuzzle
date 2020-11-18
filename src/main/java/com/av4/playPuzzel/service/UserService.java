package com.av4.playPuzzel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void saveUserInfo(UserInfo userInfo) {
		userInforRepository.save(userInfo);
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

}
