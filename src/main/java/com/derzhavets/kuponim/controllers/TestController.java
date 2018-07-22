package com.derzhavets.kuponim.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.dao.repositories.CompanyRepository;
import com.derzhavets.kuponim.dao.repositories.CouponRepository;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.services.AdminService;
import com.derzhavets.kuponim.services.CompanyService;
import com.derzhavets.kuponim.services.CustomerService;
import com.derzhavets.kuponim.services.SystemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private CouponDao coupoDao;
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/command")
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
	
	@GetMapping("/login-admin")
	public Company testAdminLogin() throws EntityNotFoundException, UserNotFoundException {
		AdminService admin = (AdminService) systemService.login("admin", "1234", ClientType.ADMIN);
		return admin.getCompany(1L);
	}

	@GetMapping("/login-company")
	public Coupon testCompanyLogin() throws EntityNotFoundException, UserNotFoundException {
		CompanyService company = (CompanyService) systemService.login("pukan", "egaswe", ClientType.COMPANY);
		return company.getCoupon(55L);
	}
	
	@GetMapping("/login-customer")
	public List<Coupon> testCustomerLogin() throws EntityNotFoundException, UserNotFoundException {
		CustomerService customer = (CustomerService) systemService.login("Michael", "pass", ClientType.CUSTOMER);
		return customer.getAllPurchasedCoupons();
	}
	
	@GetMapping("/task")
	public List<Coupon> getExpired() {
		return coupoDao.getExpiredFrom(LocalDate.now());
	}
	
}
