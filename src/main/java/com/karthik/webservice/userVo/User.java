package com.karthik.webservice.userVo;

import java.util.Date;


public class User {
	
	private String userName;
	private Integer userId;
	private Date dateOfBirth;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", dateOfBirth=" + dateOfBirth + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserName() {
		return userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public User(String userName, Integer userId, Date dateOfBirth) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.dateOfBirth = dateOfBirth;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
