package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.services.CustomerService;
import com.derzhavets.kuponim.services.SystemService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/purchase-coupon/{id}")
	public ResponseEntity<Coupon> purchaseCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
			return ResponseEntity.ok().body(
					getCustomerService(request).purchaseCoupon(Long.parseLong(request.getParameter("customer_id")), couponId));
	}
	
	@GetMapping("/get-coupons/{id}")
	public ResponseEntity<List<Coupon>> getPurchasedCoupons(@PathVariable("id") Long customerId,
				HttpServletRequest request) {
			return ResponseEntity.ok().body(
					getCustomerService(request).getAllPurchasedCoupons(customerId));
	}
	
	private CustomerService getCustomerService(HttpServletRequest request) {
		return (CustomerService) systemService.getClient(request);
	}
	
}
