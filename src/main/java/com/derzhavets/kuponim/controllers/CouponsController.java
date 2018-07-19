package com.derzhavets.kuponim.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.services.CouponService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coupons")
public class CouponsController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/")
	public List<Coupon> getAll() {
		return couponService.getAll();
	}
	
	@GetMapping("/{id}")
	public Coupon getOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		return couponService.getById(id);
	}
	
	@PostMapping("/{id}")
	public Coupon save(@RequestBody Coupon coupon, @PathVariable("id") Long companyId) throws EntityNotFoundException {
		return couponService.save(coupon, companyId);
	}
	
	@DeleteMapping("/{id}")
	public Coupon delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		return couponService.delete(id);
	}	
	@GetMapping("/types")
	public List<CouponType> getAllTypes() {
		return Arrays.asList(CouponType.values());
	}

}
	