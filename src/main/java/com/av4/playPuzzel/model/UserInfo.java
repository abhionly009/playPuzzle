package com.av4.playPuzzel.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uId;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String password;
	
	private String authToken;
	
	private boolean isMobileVerified;
	
	private boolean isEmailVerified;
	
	private String profilePic;
	
    @Column(columnDefinition = "varchar(255) default 'GENERAL'")
	private String role;
	
	@OneToMany(mappedBy = "userInfo", fetch=FetchType.LAZY)
	@JsonIgnoreProperties("userInfo")
	private List<Address> address;
	
	@Transient
	private String message;

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public boolean isMobileVerified() {
		return isMobileVerified;
	}

	public void setMobileVerified(boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", authToken=" + authToken + ", isMobileVerified=" + isMobileVerified
				+ ", isEmailVerified=" + isEmailVerified + ", message=" + message
				+ "]";
	}

	@Transient
	public String getProfilePic() {
		if (profilePic == null || uId == null) return null;
		
		return "/user-photos/" + uId + "/" + profilePic;
	}

	
	
 
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	
	
}
