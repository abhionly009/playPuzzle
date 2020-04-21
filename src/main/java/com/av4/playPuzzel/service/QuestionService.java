package com.av4.playPuzzel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Question;
import com.av4.playPuzzel.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public Question createQuestion(Question question) {
		
		questionRepository.save(question);
		
		return question;
	}

}
