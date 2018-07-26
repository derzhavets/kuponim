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
public class CompaniesController {
	
	@Autowired
	private SystemService systemService;
	
	@PostMapping("/create-coupon")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) {
		CompanyService service = (CompanyService) systemService.getClient(request);
		return ResponseEntity.ok().body(service.createCoupon(
				coupon, Long.parseLong(request.getParameter("company_id"))));
	}

	@GetMapping("/remove-coupon/{id}")
	public ResponseEntity<Coupon> removeCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		CompanyService service = (CompanyService) systemService.getClient(request);
		return ResponseEntity.ok().body(service.removeCoupon(couponId));
	}
	
	@PostMapping("/update-coupon")
	public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request) {
		CompanyService service = (CompanyService) systemService.getClient(request);
		return ResponseEntity.ok().body(service.updateCoupon(coupon));
	}
	
	@GetMapping("/get-coupon/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable Long couponId, HttpServletRequest request) {
		CompanyService service = (CompanyService) systemService.getClient(request);
		return ResponseEntity.ok().body(service.getCoupon(couponId));
	}
	
	@GetMapping("/get-all-coupons")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		CompanyService service = (CompanyService) systemService.getClient(request);
		return ResponseEntity.ok().body(
				service.getAllCoupons(Long.parseLong(request.getParameter("company_id"))));
	}

}
