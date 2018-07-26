package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class SessionNotFoundException extends KuponimApplicationException {

	public SessionNotFoundException(String msg) {
		super(msg, HttpStatus.UNAUTHORIZED);
	}

	private static final long serialVersionUID = 1L;
	
		
}
