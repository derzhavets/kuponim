package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class KuponimApplicationException extends Exception {
	
	private final HttpStatus responseStatus;
	
	private static final long serialVersionUID = 1L;

	public KuponimApplicationException(String msg, HttpStatus responseStatus) {
		super(msg);
		this.responseStatus = responseStatus;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}
	
}
