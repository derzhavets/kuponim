package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.login.Client;

public interface CompanyService extends Client {

	Coupon removeCoupon(Coupon coupon);
		
	Coupon updateCoupon(Coupon coupon);
	
	Coupon getCoupon(Long id) throws EntityNotFoundException;
	
	List<Coupon> getAllCoupons(Long companyId);
	
	List<Coupon> getCouponsByType(Long companyId, CouponType type);

	Coupon createCoupon(Coupon coupon, Long companyId) throws EntityNotFoundException;
	
}