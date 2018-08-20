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
	
	public List<Coupon> getAll() {
		return couponRepository.findAll().stream()
				.filter(c -> c.getAmount() > 0).collect(Collectors.toList());
	}
	
	
	public Coupon save(Coupon coupon) {
		return couponRepository.save(coupon);
	}

	public Coupon getById(Long id) throws EntityNotFoundException {
		return couponRepository.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Coupon with id " + id + " is not found."));
	}

	public Coupon delete(Long id) throws EntityNotFoundException {
		Coupon coupon = getById(id);
		couponRepository.delete(coupon);
		return coupon;
	}

	public List<Coupon> getExpiredFrom(LocalDate date) {
		return couponRepository.getExpiredFrom(date);
	}

	public void deleteAll(List<Coupon> coupons) {
		couponRepository.deleteAll(coupons);
	}
	
 
}
