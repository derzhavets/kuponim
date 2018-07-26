package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends KuponimApplicationException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}

}
