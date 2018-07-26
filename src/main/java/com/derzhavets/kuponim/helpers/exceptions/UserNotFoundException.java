package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends KuponimApplicationException {

	public UserNotFoundException(String msg) {
		super(msg, HttpStatus.UNAUTHORIZED);
	}

	private static final long serialVersionUID = 1L;

}
