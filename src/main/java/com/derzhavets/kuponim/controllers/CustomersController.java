package com.derzhavets.kuponim.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.exceptions.KuponimApplicationException;
import com.derzhavets.kuponim.services.CustomerService;
import com.derzhavets.kuponim.services.SystemService;

@RestController
@RequestMapping("/customer")
public class CustomersController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/purchase-coupon/{id}")
	public ResponseEntity<?> purchaseCoupon(@PathVariable("id") Long couponId, 
			HttpServletRequest request) {
		try {
			CustomerService service = (CustomerService) systemService.getClient(request);
			return ResponseEntity.ok().body(
					service.purchaseCoupon(Long.parseLong(request.getParameter("customer_id")), couponId));
		} catch (KuponimApplicationException e) {
			return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
		}
	}
	
	@GetMapping("/get-coupons/{id}")
	public ResponseEntity<?> getPurchasedCoupons(@PathVariable("id") Long customerId,
				HttpServletRequest request) {
		try {
			CustomerService service = (CustomerService) systemService.getClient(request);
			return ResponseEntity.ok().body(
					service.getAllPurchasedCoupons(customerId));
		} catch (KuponimApplicationException e) {
			return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
		}
	}
	
	@GetMapping("/get-coupons-by-type/{id}")
	public ResponseEntity<?> getPurchasedCouponsByType(@PathVariable("id") Long customerId,
			HttpServletRequest request) {
		try {
			CustomerService service = (CustomerService) systemService.getClient(request);
			return ResponseEntity.ok().body(
					service.getAllPurchasedCouponsByType(customerId, 
							CouponType.valueOf(request.getParameter("coupon-type"))));
		} catch (KuponimApplicationException e) {
			return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
		}
	}
	
}
