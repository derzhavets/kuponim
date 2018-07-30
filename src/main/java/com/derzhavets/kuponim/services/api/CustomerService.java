package com.derzhavets.kuponim.services.api;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.exceptions.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

public interface CustomerService extends Client {

	Coupon purchaseCoupon(Long customerId, Long couponId) throws EntityNotFoundException, CouponTypeNotAllowedException;

	List<Coupon> getAllPurchasedCoupons(Long customerId) throws EntityNotFoundException;

	List<Coupon> getAllPurchasedCouponsByType(Long customerId, CouponType type) throws EntityNotFoundException;

}