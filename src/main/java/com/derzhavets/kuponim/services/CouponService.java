package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;

public interface CouponService {

	List<Coupon> getAll();

	Coupon save(Coupon c, Long companyId) throws EntityNotFoundException;

	Coupon getById(Long id) throws EntityNotFoundException;

	Coupon delete(Long id) throws EntityNotFoundException;
	
}