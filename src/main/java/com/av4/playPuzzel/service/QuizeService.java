package com.av4.playPuzzel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av4.playPuzzel.model.Answer;
import com.av4.playPuzzel.model.Question;
import com.av4.playPuzzel.model.Quize;
import com.av4.playPuzzel.repository.QuizeRepository;

@Service
public class QuizeService {

	@Autowired
	QuizeRepository quizeRepository;

	public Quize createQuize(Quize quize) {

		return quizeRepository.save(quize);
	}

	public Quize getQuize(String name) {

		Quize quizeResponse = quizeRepository.findQuizeByName(name);
		
		if (quizeResponse!=null) {
			
		

		List<Question> questions = quizeResponse.getQuestion();

		for (int i = 0; i < questions.size(); i++) {

			Question question = questions.get(i);

			List<Answer> ans = question.getAnswer();

			for (int j = 0; j < ans.size(); j++) {

				ans.get(j).setCorrectAnswer(null);

			}

		}
		
		return quizeResponse;
		}
		else {
			return new Quize();	
		}

		
	}
}
