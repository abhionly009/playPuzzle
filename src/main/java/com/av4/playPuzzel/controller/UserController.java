package com.av4.playPuzzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.av4.playPuzzel.model.Login;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.model.UserInfoWithoutSensibleInfo;
import com.av4.playPuzzel.service.EmailNotificationService;
import com.av4.playPuzzel.service.UserService;
import com.av4.playPuzzel.utils.AuthTokenUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailNotificationService emaiService;

	@PostMapping("/register")
	public UserInfo createUser(@RequestBody UserInfo info) {

		
			if (userService.findUserByEmailId(info.getEmail()) || userService.findUserByMobile(info.getMobile())) {
				info.setMessage("User already exist with email or Password please check and try again");
				info.setPassword(null);
				return info;

			} else {
				
				UserInfo userInfo = new UserInfo();
				
				userInfo.setName(info.getName());
				userInfo.setEmail(info.getEmail());
				userInfo.setMobile(info.getMobile());
				userInfo.setMobileVerified(false);
				userInfo.setEmailVerified(false);
				
				userInfo.setAuthToken(AuthTokenUtil.generateNewToken());
				userInfo.setPassword(AuthTokenUtil.cryptWithMD5(info.getPassword()));
				
				userService.saveUserInfo(userInfo);
				userInfo.setMessage("User has been created successfully ");
				userInfo.setAuthToken(null);
				userInfo.setPassword(null);
				return userInfo;
			}
	}
	
	
	@PostMapping("/login")
	public UserInfo loginUser(@RequestBody Login loginUser) {
		
		UserInfo userInfo = null;
		userInfo=  userService.checkUserCredentials( loginUser.getEmailId(), AuthTokenUtil.cryptWithMD5(loginUser.getPassword()));
			
		System.out.println(loginUser.getEmailId());
		System.out.println(loginUser.getPassword());

		
		if (userInfo!=null) {
			userInfo.setMessage("User has been logged in successfully");
			userInfo.setPassword("");	
			
		} else {
			userInfo = new UserInfo();
			userInfo.setMessage("User not found");
			userInfo.setPassword("");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST," found with your credentials");

		}
		
		System.out.println(userInfo.toString());
		
		return userInfo;
		
		
	}
	
	@GetMapping("/verifyEmail")
	public String verifyMyMail(@Param(value="authToken")String authToken) {
		
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);
		
		String email = userInfo.getEmail();
		boolean isEmailVerified = userInfo.isEmailVerified();
		
		if (isEmailVerified)
			return "Email already verified";
		else 
		{
			try {
				emaiService.sendNotification(email);

			}catch (MailException e) {
				// TODO: handle exception
			}
			return "Verification link has been send to your register email";
		}
		
	}
	
	@GetMapping("/userList")
	public List<UserInfoWithoutSensibleInfo> getUsers(){
					
		return userService.getUserDetails();
	}

}
