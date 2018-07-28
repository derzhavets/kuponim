package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.services.CompanyService;
import com.derzhavets.kuponim.services.SystemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private SystemService systemService;
	
	@PostMapping("/create-coupon")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).createCoupon(
				coupon, Long.parseLong(request.getParameter("company_id"))));
	}


	@GetMapping("/remove-coupon/{id}")
	public ResponseEntity<Coupon> removeCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		CompanyService service = getCompanyService(request);
		return ResponseEntity.ok().body(service.removeCoupon(couponId));
	}
	
	@PostMapping("/update-coupon")
	public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).updateCoupon(coupon));
	}
	
	@GetMapping("/get-coupon/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable Long couponId, HttpServletRequest request) {
		CompanyService service = getCompanyService(request);
		return ResponseEntity.ok().body(service.getCoupon(couponId));
	}
	
	@GetMapping("/get-all-coupons")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		return ResponseEntity.ok().body(
				getCompanyService(request).getAllCoupons(Long.parseLong(request.getParameter("company_id"))));
	}

	private CompanyService getCompanyService(HttpServletRequest request) {
		return (CompanyService) systemService.getClient(request);
	}
	
}