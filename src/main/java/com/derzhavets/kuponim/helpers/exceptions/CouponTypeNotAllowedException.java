package com.derzhavets.kuponim.helpers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CouponTypeNotAllowedException extends KuponimApplicationException {

	public CouponTypeNotAllowedException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;
	
	
}
