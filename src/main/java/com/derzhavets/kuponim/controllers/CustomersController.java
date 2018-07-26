package com.derzhavets.kuponim.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.KuponimApplicationException;
import com.derzhavets.kuponim.helpers.exceptions.SessionNotFoundException;
import com.derzhavets.kuponim.services.CustomerService;
import com.derzhavets.kuponim.services.SystemService;

@RestController
@RequestMapping("/customer")
public class CustomersController {
	
	@Autowired
	private SystemService systemService;
	
	@GetMapping("/purchase-coupon/{id}")
	public ResponseEntity<?> purchaseCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) 
					throws KuponimApplicationException {
			CustomerService service = (CustomerService) systemService.getClient(request);
			return ResponseEntity.ok().body(
					service.purchaseCoupon(Long.parseLong(request.getParameter("customer_id")), couponId));
	}
	
	@GetMapping("/get-coupons/{id}")
	public ResponseEntity<?> getPurchasedCoupons(@PathVariable("id") Long customerId,
				HttpServletRequest request) throws SessionNotFoundException, EntityNotFoundException {
			CustomerService service = (CustomerService) systemService.getClient(request);
			return ResponseEntity.ok().body(
					service.getAllPurchasedCoupons(customerId));
	}

	
}
