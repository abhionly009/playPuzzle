//package com.av4.playPuzzel.model;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.av4.playPuzzel.repository.UserInforRepository;
//
//public class CustomUserDetailsService implements UserDetailsService{
//
//	
//	@Autowired
//	UserInforRepository userInfoRepository;
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//	    return super.userDetailsService();
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		UserInfo userInfo=  userInfoRepository.findUserByEmail(username);
//		
//		if (username.equals(userInfo.getEmail())) {
//			return new User(userInfo.getName(),userInfo.getPassword(),new ArrayList<>());
////			return new User(userInfo.getName(), new ArrayList<GrantedAuthority>());
//		}else {
//			throw new UsernameNotFoundException("User Not found by this email");
//		}
//	}
//
//}
