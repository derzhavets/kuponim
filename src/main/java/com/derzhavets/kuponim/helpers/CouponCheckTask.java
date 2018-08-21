package com.derzhavets.kuponim.helpers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.entities.Coupon;

@Component
public class CouponCheckTask {
	
	@Autowired
	private CouponDao couponDao;
	
	/**
	 * Once in a 24 retrieve all expired coupons from the database and delete them
	 */
	@Scheduled(fixedRate = 1000 * 3600 * 24)
	public void deleteExpiredCoupons() {
		List<Coupon> coupons = couponDao.getExpiredFrom(LocalDate.now());
		couponDao.deleteAll(coupons);
	}
}
