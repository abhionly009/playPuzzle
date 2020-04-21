package com.av4.playPuzzel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Column(unique = true, nullable = false)
	private String question_info;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quesion_id; 
	
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

	
	
	
	
}
