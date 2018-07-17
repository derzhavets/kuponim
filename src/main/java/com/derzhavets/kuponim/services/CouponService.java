package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;

public interface CouponService {

	List<Coupon> getAll();

	Coupon save(Coupon c, Long companyId);

	Coupon getById(Long id) throws Exception;

	void delete(Long id);
	
}