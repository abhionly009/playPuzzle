package com.av4.playPuzzel.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Column( nullable = false)
	private String question_info;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quesion_id; 
	
	@OneToMany(cascade =CascadeType.ALL )
	private List<Answer> answer;
	
	public String getQuestion_info() {
		return question_info;
	}

	public void setQuestion_info(String question_info) {
		this.question_info = question_info;
	}

	public Long getQuesion_id() {
		return quesion_id;
	}

	public void setQuesion_id(Long quesion_id) {
		this.quesion_id = quesion_id;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	
	
	
	
}
