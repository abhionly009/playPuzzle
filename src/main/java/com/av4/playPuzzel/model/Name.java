package com.av4.playPuzzel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Name {

@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private Integer count;

private String userName;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getCount() {
	return count;
}

public void setCount(Integer count) {
	this.count = count;
}

@Override
public String toString() {
	return "Name [id=" + id + ", count=" + count + ", userName=" + userName + "]";
}

	
}
