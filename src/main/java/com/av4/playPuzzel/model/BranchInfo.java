package com.av4.playPuzzel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BranchInfo {

	@Id
	private Long branchId;
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	private String branchName;
	public BranchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
