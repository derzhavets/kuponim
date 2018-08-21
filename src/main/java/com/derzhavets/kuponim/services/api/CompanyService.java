package com.derzhavets.kuponim.services.api;

import java.util.List;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

public interface CompanyService extends Client {
	
	/**
	 * Create new coupon to be purchased by a customers
	 * 
	 * @param coupon entity to be created
	 * @param companyId of the company issuing the coupon
	 * @return created coupon entity
	 * @throws EntityNotFoundException in case company with provided id was not found
	 */
	Coupon createCoupon(Coupon coupon, Long companyId) throws EntityNotFoundException;
	
	/**
	 * Remove coupon from the system
	 * 
	 * @param couponId of the coupon entity to be deleted
	 * @return deleted coupon entity
	 * @throws EntityNotFoundException in case coupon with provided id was not found
	 */
	Coupon removeCoupon(Long couponId) throws EntityNotFoundException;
	
	/**
	 * Update existing coupons with new data
	 * 
	 * @param coupon to be updated
	 * @return updated coupon entity
	 */
	Coupon updateCoupon(Coupon coupon);
	
	/**
	 * Get coupon from the system
	 * 
	 * @param id of the coupon to be retrieved
	 * @return coupon entity
	 * @throws EntityNotFoundException in case coupon with provided id was not found
	 */
	Coupon getCoupon(Long id) throws EntityNotFoundException;
	
	/**
	 * Get all the coupons issued by a certain company
	 * 
	 * @param companyId of the company whose coupons need to be retrieved
	 * @return list of found coupons issued by the company
	 * @throws EntityNotFoundException is case company with provided id was not found
	 */
	List<Coupon> getAllCoupons(Long companyId) throws EntityNotFoundException;
	
	/**
	 * Get all the coupons issued by a certain company filtered by coupon type
	 * 
	 * @param companyId of the company whose coupons need to be retrieved
	 * @param type of coupons to retrieve
	 * @return list of found coupons of provided type issued by the company
	 * @throws EntityNotFoundException is case company with provided id was not found
	 */
	List<Coupon> getCouponsByType(Long companyId, CouponType type) throws EntityNotFoundException;
	
	/**
	 * Get all registered in the system coupon types to be assigned to a coupons being issued
	 * 
	 * @return list of available coupon types
	 */
	List<CouponType> getCouponTypes();
	
}