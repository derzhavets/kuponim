package com.derzhavets.kuponim.services.api;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

public interface CompanyService extends Client {

	Coupon createCoupon(Coupon coupon, Long companyId) throws EntityNotFoundException;

	Coupon removeCoupon(Long couponId) throws EntityNotFoundException;
		
	Coupon updateCoupon(Coupon coupon);
	
	Coupon getCoupon(Long id) throws EntityNotFoundException;
	
	List<Coupon> getAllCoupons(Long companyId) throws EntityNotFoundException;
	
	List<Coupon> getCouponsByType(Long companyId, CouponType type) throws EntityNotFoundException;

	List<CouponType> getCouponTypes();
	
}