package com.karthik.webservice.userVo;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User Model class")
public class User {

	@Size(min = 2, message = "Name must contain atleast 2 characters")
	@ApiModelProperty(notes = "Name should contain atleast 2 characters", required = true)
	private String userName;

	@Nullable
	@ApiModelProperty(hidden = true)
	private Integer userId;

	@Past(message = "Date cannot be further ....")
	@ApiModelProperty(notes = "Birth date cannot be future date", required = true)
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
