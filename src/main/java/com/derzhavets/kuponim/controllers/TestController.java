package com.derzhavets.kuponim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.dao.repositories.CompanyRepository;
import com.derzhavets.kuponim.dao.repositories.CouponRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.login.Client;
import com.derzhavets.kuponim.services.AdminService;
import com.derzhavets.kuponim.services.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private LoginService loginService;
	
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
	
	@GetMapping("/test-login")
	public Company testLogin() throws EntityNotFoundException {
		AdminService admin = (AdminService) loginService.login();
		return admin.getCompany(1L);
	}
	
}
