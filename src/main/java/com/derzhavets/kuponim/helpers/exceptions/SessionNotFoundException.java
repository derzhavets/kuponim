package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class SessionNotFoundException extends KuponimApplicationException {

	public SessionNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;
	
		
}
