package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends KuponimApplicationException{

	public UserNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

}
