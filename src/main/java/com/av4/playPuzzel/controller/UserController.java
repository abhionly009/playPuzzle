package com.av4.playPuzzel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.av4.playPuzzel.model.Cart;
import com.av4.playPuzzel.model.Home;
import com.av4.playPuzzel.model.Login;
import com.av4.playPuzzel.model.Product;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.model.UserInfoWithoutSensibleInfo;
import com.av4.playPuzzel.service.CartService;
import com.av4.playPuzzel.service.EmailNotificationService;
import com.av4.playPuzzel.service.ProductService;
import com.av4.playPuzzel.service.UserService;
import com.av4.playPuzzel.utils.AuthTokenUtil;
import com.av4.playPuzzel.utils.FileUploadUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	private EmailNotificationService emaiService;

	@PostMapping("/register")
	public UserInfo createUser(@RequestBody UserInfo info) throws IOException{

		
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
				userInfo.setPassword(AuthTokenUtil.cryptWithMD5(info.getPassword()));
				userInfo.setRole(info.getRole());

				userService.saveUserInfo(userInfo);
				userInfo.setMessage("User has been created successfully ");
				userInfo.setAuthToken(null);
				userInfo.setPassword(null);
				
				
				
				return userInfo;
			}
	}
	
	@PostMapping("/updateProfile")
	public UserInfo updateProfilePic(@RequestParam("image") MultipartFile multipartFile,@Param(value="authToken")String authToken) throws IOException {
		
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);

		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		userService.saveUserInfo(userInfo);

//		userInfo.setProfilePic(fileName);
		
		int status =	userService.updateProfilePic(authToken,fileName);
		
		System.out.println(status+" This means");
		
		String uploadDir = "user-photos/" + userInfo.getuId();
		 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        
//        userInfo.setProfilePic()
        
        return userInfo;
	}
	
	@PostMapping("/login")
	public Home loginUser(@RequestBody Login loginUser, HttpServletRequest httpServletRequest) {
		
		System.out.println("REQUESTER IP ADDRESS " + httpServletRequest.getRequestURI());
		
		System.out.println("REQUESTER IP ADDRESS " + httpServletRequest.getRemoteAddr());
		
		System.out.println(loginUser.getEmailId());
		System.out.println(loginUser.getPassword());

		
		Home homePage = new Home();
		UserInfo userInfo = null;
		userInfo=  userService.checkUserCredentials( loginUser.getEmailId(), AuthTokenUtil.cryptWithMD5(loginUser.getPassword()));
		
			
		
		if (userInfo!=null) {
			userInfo.setMessage("User has been logged in successfully");
			String authToken = AuthTokenUtil.generateNewToken();
			userInfo.setAuthToken(authToken);
			userService.updateAuthToken(authToken, loginUser.getEmailId());
			userInfo.setPassword("");
			List<Product> cartList = cartService.getAllProduct(userInfo);
			homePage.setCart(cartList);
			homePage.setProductList(productService.getAllProduct());
			
		} else {
			userInfo = new UserInfo();
			userInfo.setMessage("User not found");
			userInfo.setPassword("");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"  No User found with your credentials");

		}
		
		
		homePage.setUserInfo(userInfo);

		return homePage;
		
		
	}
	
	@PostMapping("/logout")
	public String logoutUser(@Param(value="authToken") String authToken) {
		
		UserInfo userInfo =	userService.findUserByAuthToken(authToken);
		
		String message = "";
		
		if (userInfo!= null) {
			int logoutStatus = userService.logoutUserBySettingAuthEnpty(authToken);
			if (logoutStatus>0) {
				message = "User logged out successfully";
			}else {
				message = "something went wrong please try after sometime";
			}
			
		}
		
		return message;

		
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
