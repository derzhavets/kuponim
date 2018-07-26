package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class CouponTypeNotAllowedException extends KuponimApplicationException {

	public CouponTypeNotAllowedException(String msg) {
		super(msg, HttpStatus.BAD_REQUEST);
	}

	private static final long serialVersionUID = 1L;
	
	
}
