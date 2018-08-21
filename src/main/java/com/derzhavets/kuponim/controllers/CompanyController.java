package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.derzhavets.kuponim.helpers.CouponType;
import com.derzhavets.kuponim.services.api.CompanyService;
import com.derzhavets.kuponim.services.api.SystemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController  
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private SystemService systemService;
	
	/**
	 * Retrieve coupon entity from POST request and pass it to respective service to 
	 * process and save
	 * 
	 * @param coupon to save in the database
	 * @param request to check if client request is authorized, also contains param company_id -
	 * id of the company issuing the coupon
	 * @return ResponseEntity with created coupon entity
	 */
	@PostMapping("/create-coupon")
	public ResponseEntity<Coupon> createCoupon(@Valid @RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).createCoupon(
				coupon, Long.parseLong(request.getParameter("company_id"))));
	}

	/**
	 * Delete coupon with received id from database
	 * 
	 * @param couponId of the coupon to delete from database
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with deleted coupon entity
	 */
	@GetMapping("/delete-coupon/{id}")
	public ResponseEntity<Coupon> removeCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).removeCoupon(couponId));
	}
	
	/**
	 * Retrieve updated coupons from POST request and pass it to respective service to update
	 * coupons in the database
	 * 
	 * @param coupon entity to update in the database
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with updated coupon entity
	 */
	@PostMapping("/update-coupon")
	public ResponseEntity<Coupon> updateCoupon(@Valid @RequestBody Coupon coupon, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).updateCoupon(coupon));
	}
	
	/**
	 * Get coupon entity based on received coupon id
	 * 
	 * @param couponId of coupon entity to be retrieved from the database
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with requested coupon entity
	 */
	@GetMapping("/get-coupon/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id") Long couponId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getCompanyService(request).getCoupon(couponId));
	}
	
	/**
	 * Get all coupons issued by the company
	 * 
	 * @param request to check if client request is authorized, also contains param company_id -
	 * id of the company issued the coupons
	 * @return ResponseEntity with list of all coupons in the database
	 */
	@GetMapping("/get-all-coupons")
	public ResponseEntity<List<Coupon>> getAllCoupons(HttpServletRequest request) {
		return ResponseEntity.ok().body(
				getCompanyService(request).getAllCoupons(Long.parseLong(request.getParameter("company_id"))));
	}
 
	/**
	 * Get all coupon types available in the system to assign a type to a coupon being created
	 * 
	 * @param request to check if client request is authorized
	 * @return ResponseEntity with list of all coupon types
	 */
	@GetMapping("/get-coupon-types")
	public ResponseEntity<List<CouponType>> getCouponTypes(HttpServletRequest request) {
		return ResponseEntity.ok().body(
				getCompanyService(request).getCouponTypes());
	} 
	
	/**
	 * Fetches CompanyService from SystemService through authorization filter
	 * 
	 * @param request to check if client request is authorized
	 * @return CompanyService to use in controller endpoints
	 */
	private CompanyService getCompanyService(HttpServletRequest request) {
		return (CompanyService) systemService.getClient(request);
	}
 	
}
