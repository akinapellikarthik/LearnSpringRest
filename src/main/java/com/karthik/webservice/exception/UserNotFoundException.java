package com.karthik.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {

	}

	public UserNotFoundException(String msg) {
		super(msg);
	}

	public UserNotFoundException(Exception e) {
		super(e);
	}

}
