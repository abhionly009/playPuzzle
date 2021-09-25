package com.av4.playPuzzel.model;

public class InitialInfo {

	private String name;
	private long count;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public InitialInfo(String name, long count) {
		super();
		this.name = name;
		this.count = count;
	}
	
}
