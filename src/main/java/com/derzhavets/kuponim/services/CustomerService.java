package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.login.Client;

public interface CustomerService extends Client {

	Coupon purchaseCoupon(Coupon coupon, Long customerId);

	List<Coupon> getAllPurchasedCoupons();

	List<Coupon> getAllPurchasedCouponsByType(CouponType type);

}