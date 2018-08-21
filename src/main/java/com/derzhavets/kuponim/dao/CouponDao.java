package com.derzhavets.kuponim.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CouponRepository;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

@Service
public class CouponDao {
	
	@Autowired
	private CouponRepository couponRepository;
	
	/**
	 * Get all the coupons issued in the system, filtering out coupons whose amount is exceeded
	 * thus are not available to be purchased
	 * 
	 * @return list of coupon entities found in the database
	 */
	public List<Coupon> getAll() {
		return couponRepository.findAll().stream()
				.filter(c -> c.getAmount() > 0).collect(Collectors.toList());
	}
	
	/**
	 * Pass coupon entity to be saved to the company repository
	 * 
	 * @param coupon entity to be saved
	 * @return saved company entity
	 */
	public Coupon save(Coupon coupon) {
		return couponRepository.save(coupon);
	}
	
	/**
	 * Retrieve coupon entity based on company id
	 * 
	 * @param id of the coupon to be retieved from the database
	 * @return found coupon entity
	 * @throws EntityNotFoundException in case coupon with received id is not found in the 
	 * database
	 */
	public Coupon getById(Long id) throws EntityNotFoundException {
		return couponRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Coupon with id " + id + " is not found."));
	}

	/**
	 * Delete coupon entity based on company id
	 * 
	 * @param id of the coupon to be deleted from the database
	 * @return deleted coupon entity
	 * @throws EntityNotFoundException in case coupon with received id is not found in the 
	 * database
	 */
	public Coupon delete(Long id) throws EntityNotFoundException {
		Coupon coupon = getById(id);
		couponRepository.delete(coupon);
		return coupon;
	}

	/**
	 * Retrieve all the coupons whose end date is farther than the date received
	 * 
	 * @param date to compare with coupon entities end date
	 * @return
	 */
	public List<Coupon> getExpiredFrom(LocalDate date) {
		return couponRepository.getExpiredFrom(date);
	}

	/**
	 * Delete all the coupon entities received
	 * 
	 * @param coupons list to be deleted
	 */
	public void deleteAll(List<Coupon> coupons) {
		couponRepository.deleteAll(coupons);
	}
	
 
}
