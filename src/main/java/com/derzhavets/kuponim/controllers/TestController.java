package com.derzhavets.kuponim.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.dao.CouponDao;
import com.derzhavets.kuponim.dao.repositories.CompanyRepository;
import com.derzhavets.kuponim.dao.repositories.CouponRepository;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.entities.Income;
import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.IncomeType;
import com.derzhavets.kuponim.helpers.exceptions.CouponTypeNotAllowedException;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.SessionNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.AdminService;
import com.derzhavets.kuponim.services.api.CustomerService;
import com.derzhavets.kuponim.services.api.SystemService;

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
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/command")
	public String test() {
//		Coupon coupon = couponRepo.findById(37L).get();
//		Company company = companyRepo.findById(6L).get();
//		
//		coupon.setCompany(company);
//		couponRepo.save(coupon);
//		company.getCoupons().add(coupon);
//		companyRepo.save(company);
//		
//		System.out.println("COMPANY: " + company);
//		System.out.println("COUPON: " + coupon );
	
		Income income = new Income("Apple", IncomeType.COMPANY_NEW_COUPON, 19.99);
		return income.toJson();
	}
	
	@GetMapping("/buy-coupon")
	public Coupon buy() throws EntityNotFoundException, CouponTypeNotAllowedException {
		return customerService.purchaseCoupon(1L, 69L);
	}
	
	@GetMapping("/task")
	public List<Coupon> getExpired() {
		return coupoDao.getExpiredFrom(LocalDate.now());
	}
	 
	@GetMapping("/login")
	public KuponimUser setSession(HttpServletRequest request) throws UserNotFoundException {
		return systemService.login(request);
	}
	
	@GetMapping("/get-service")
	public Customer getNewService(HttpServletRequest request) throws SessionNotFoundException, EntityNotFoundException {
		AdminService service = (AdminService) systemService.getClient(request);
		return service.getCustomer(1L);
	}
	
	@GetMapping("/get-session")
	public String getCustomer(HttpServletRequest request) {
		String id = request.getSession(false).getId();
		return id;
	}
	
	@GetMapping("/get-cookie")
	public String getCookie(HttpServletRequest request) {
		return request.getHeader("Cookie");
	}
	
}
