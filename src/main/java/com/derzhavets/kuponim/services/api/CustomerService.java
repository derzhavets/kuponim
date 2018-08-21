package com.derzhavets.kuponim.services.api;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.exceptions.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

public interface CustomerService extends Client {
	
	/**
	 * Purchase a coupon by a customer by retrieving necessary coupon from the system
	 * and adding it to a customer coupons
	 * 
	 * @param customerId of customer purchasing a coupon
	 * @param couponId of coupon to be purchased
	 * @return purchased coupon entity
	 * @throws EntityNotFoundException in case customer or coupon with provided id were not found
	 * @throws CouponTypeNotAllowedException in case customer already purchased coupon that has
	 * the same coupon type as a coupon to be purchased
	 */
	Coupon purchaseCoupon(Long customerId, Long couponId) throws EntityNotFoundException, CouponTypeNotAllowedException;
	
	/**
	 * Retrieve all the coupons purchased by a certain customer
	 * 
	 * @param customerId of a customer
	 * @return list of coupons purchased by a customer with provided id
	 * @throws EntityNotFoundException is case customer with provided id was not found
	 */
	List<Coupon> getAllPurchasedCoupons(Long customerId) throws EntityNotFoundException;
	
	/**
	 * Retrieve all the coupons purchased by a certain customer filtered by coupon type
	 * 
	 * @param customerId of a customer
	 * @param type of a coupons to be retrieved
	 * @return list of coupons of requested type purchased by a customer with provided id
	 * @throws EntityNotFoundException in case customer with provided id was not found
	 */
	List<Coupon> getAllPurchasedCouponsByType(Long customerId, CouponType type) throws EntityNotFoundException;
	
	/**
	 * Gel all the coupons in the system that available to purchase
	 * 
	 * @return list of available to purchase coupons
	 */
	List<Coupon> getAllCoupons();

}