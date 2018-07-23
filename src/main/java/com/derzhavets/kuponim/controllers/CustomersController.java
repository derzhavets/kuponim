package com.derzhavets.kuponim.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Coupon;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	
	@GetMapping("/purchase-coupon/{id}")
	public ResponseEntity<Coupon> purchaseCoupon(@PathVariable("id") Long couponId) {
		return ResponseEntity.ok()
				.header("Random header", "Fuck me header").body(new Coupon());
	}
	
}
