package com.derzhavets.kuponim.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.derzhavets.kuponim.dao.CouponDao;

@Component
public class CouponCheckTask {
	
	@Autowired
	private CouponDao couponDao;
	
	@Scheduled(fixedRate = 1000 * 3600 * 24)
	public void deleteExpiredCoupons() {
		
	}
}
