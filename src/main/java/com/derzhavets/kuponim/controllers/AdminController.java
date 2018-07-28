package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.services.AdminService;
import com.derzhavets.kuponim.services.SystemService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SystemService systemService;
	
	@PostMapping("/save-company")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCompany(company));
	}


	@GetMapping("/delete-company/{id}")
	public ResponseEntity<Company> removeCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCompany(companyId));
	}
	
	@GetMapping("/get-company/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCompany(companyId));
	}

	@GetMapping("/get-all-companies")
	public ResponseEntity<List<Company>> getAllCompanies(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCompanies());
	}
	
	@PostMapping("/save-customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCustomer(customer));
	}
	
	@GetMapping("/delete-customer/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCustomer(customerId));
	}

	@GetMapping("/get-customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCustomer(customerId));
	}
	
	@GetMapping("/get-all-customers")
	public ResponseEntity<List<Customer>> getAllCustomers(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCustomers());
	}
	
	private AdminService getAdminService(HttpServletRequest request) {
		return (AdminService) systemService.getClient(request);
	}
	
}
