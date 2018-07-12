package com.derzhavets.kuponim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.dao.CompanyRepository;
import com.derzhavets.kuponim.dao.CouponRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
	@GetMapping("/test")
	public void test() {
		Coupon coupon = couponRepo.findById(37L).get();
		Company company = companyRepo.findById(6L).get();
		
//		coupon.setCompany(company);
//		couponRepo.save(coupon);
//		company.getCoupons().add(coupon);
//		companyRepo.save(company);
		
		System.out.println("COMPANY: " + company);
		System.out.println("COUPON: " + coupon );
	}
}
