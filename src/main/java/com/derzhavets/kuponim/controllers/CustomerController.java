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
import com.derzhavets.kuponim.services.api.CustomerService;
import com.derzhavets.kuponim.services.api.SystemService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private SystemService systemService;
	
	/**
	 * Purchase selected coupon by a customer
	 * 
	 * @param couponId of the coupon entity to be purchased by a customer
	 * @param request to check if client request is authorized, also contains param customer_id -
	 * id of the customer purchasing the coupon
	 * @return ResponseEntity purchased coupon entity
	 */
	@GetMapping("/purchase-coupon/{id}")
	public ResponseEntity<Coupon> purchaseCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
			return ResponseEntity.ok().body( 
					getCustomerService(request).purchaseCoupon(Long.parseLong(request.getParameter("customer_id")), couponId));
	}
	
	/**
	 * Get all the coupons purchased by selected customer
	 * 
	 * @param customerId of the customer whose purchased coupons need to be retrieved
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with list of coupons purchased by the customer
	 */
	@GetMapping("/get-coupons/{id}")
	public ResponseEntity<List<Coupon>> getPurchasedCoupons(@PathVariable("id") Long customerId,
				HttpServletRequest request) {
			return ResponseEntity.ok().body(
					getCustomerService(request).getAllPurchasedCoupons(customerId));
	}
	
	/**
	 * Get all the coupons from the system that can be purchased by a customer
	 * 
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with all the coupons from the system
	 */
	@GetMapping("/get-all-coupons")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		return ResponseEntity.ok().body(getCustomerService(request).getAllCoupons());
	}
	
	/**
	 * Fetches CustomerService from SystemService through authorization filter
	 * 
	 * @param request to check if client request is authorized
	 * @return CustomerService to use in controller endpoints
	 */
	private CustomerService getCustomerService(HttpServletRequest request) {
		return (CustomerService) systemService.getClient(request);
	}
	 
}
