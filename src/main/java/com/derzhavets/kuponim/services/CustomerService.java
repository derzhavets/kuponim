package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.login.Client;

public interface CustomerService extends Client {

	Coupon purchaseCoupon(Long customerId, Long couponId) throws EntityNotFoundException, CouponTypeNotAllowedException;

	List<Coupon> getAllPurchasedCoupons(Long customerId);

	List<Coupon> getAllPurchasedCouponsByType(Long customerId, CouponType type);

}