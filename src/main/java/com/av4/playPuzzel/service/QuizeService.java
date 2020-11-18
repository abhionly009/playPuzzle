package com.av4.playPuzzel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Answer;
import com.av4.playPuzzel.model.Question;
import com.av4.playPuzzel.model.Quize;
import com.av4.playPuzzel.model.UserInfo;
import com.av4.playPuzzel.repository.QuizeRepository;
import com.av4.playPuzzel.repository.UserInforRepository;

@Service
public class QuizeService {

	@Autowired
	QuizeRepository quizeRepository;

	@Autowired
	UserInforRepository userInforRepository;

	public Quize createQuize(Quize quize) {

		return quizeRepository.save(quize);
	}

	public Quize getQuize(String name) {

		Quize quizeResponse = quizeRepository.findQuizeByName(name);
		System.out.println("Quize respose" + quizeResponse);

//
//		if (quizeResponse != null) {
//
//			List<Question> questions = quizeResponse.getQuestion();
//
//			for (int i = 0; i < questions.size(); i++) {
//
//				Question question = questions.get(i);
//
//				List<Answer> ans = question.getAnswer();
//
//				for (int j = 0; j < ans.size(); j++) {
//
//					ans.get(j).setCorrectAnswer(null);
//
//				}
//
//			}
//
//			return quizeResponse;
//		} else {
//			return new Quize();
//		}
		
		return quizeResponse;

	}

	public String enrollUser(Long quizeId, Long userId) {
//		
//		UserInfo usrInfo2 = userInforRepository.getUserInfoById(userId);
//		List<UserInfo> userInfos = new ArrayList<UserInfo>();
//		 userInfos.add(usrInfo2); 
//		
//		Quize quize = quizeRepository.findEnrolledQuizeByUserId(usrInfo2);

		
		  String returningMsg = "";
		  
//		  List <UserInfo> userInfo = quize.getUserInfo();
//		  
//		  for (UserInfo userInfo2 :userInfo) {
//		  
//		  if (userInfo2.getuId()==userId) { return returningMsg =
//		  "You have already registered in this course";
//		  
//		  } }
//		  
//		  UserInfo usrInfo2 = userInforRepository.getUserInfoById(userId);
//		  
//		  List<UserInfo> userInfos = new ArrayList<UserInfo>();
//		  userInfos.add(usrInfo2); 
//		  
		  Quize quize2 =  quizeRepository.enrollUser(userId,quizeId);
		  
		  
		 

		return "You are successfully enrolled to quize";

	}
}
