package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.dao.CompanyDao;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Coupon;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.services.CompanyService;
import com.derzhavets.kuponim.services.SystemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/companies")
public class CompaniesController {
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private CompanyDao companyDao;
	
	@PostMapping("/create-coupon")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) {
		try {
			CompanyService service = (CompanyService) systemService.getClient(request);
			return ResponseEntity.ok().body(service.createCoupon(
					coupon, (Long) request.getAttribute("company_id")));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/get-coupon/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable Long coupondId) {
		return null;
		
	}
	
	@GetMapping("/")
	public List<Company> getAll() {
		return companyDao.getAll();
	}
	
	@GetMapping("/{id}")
	public Company getOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		return companyDao.getById(id);
	}
	
	@PostMapping("/")
	public Company save(@RequestBody Company company) {
		return companyDao.save(company);
	}
	
	@DeleteMapping("/{id}")
	public Company delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		return companyDao.delete(id);
	}

}
