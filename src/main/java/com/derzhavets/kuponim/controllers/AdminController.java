package com.derzhavets.kuponim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.derzhavets.kuponim.services.api.AdminService;
import com.derzhavets.kuponim.services.api.SystemService;

@RestController
@RequestMapping("/admin")
public class AdminController { 
	
	@Autowired
	private SystemService systemService;
	
	/**
	 * Retrieves company entity from POST request and passes it to respective service to process
	 * 
	 * @param company to be saved
	 * @param request to check if client request is authorized
	 * @return company entity saved in database
	 */
	@PostMapping("/save-company")
	public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company company, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCompany(company));
	}

	/**
	 * Delete company based on received company id
	 * 
	 * @param companyId of company to be deleted
	 * @param request to check if client request is authorized
	 * @return deleted company entity
	 */
	@GetMapping("/delete-company/{id}")
	public ResponseEntity<Company> removeCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCompany(companyId));
	}
	
	/**
	 * Get company entity based on received company id
	 * 
	 * @param companyId of company to be retrieved
	 * @param request to check if client request is authorized
	 * @return retrieved company entity
	 */
	@GetMapping("/get-company/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long companyId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCompany(companyId));
	}
	
	/**
	 * Retrieve all the company accounts registered in the system
	 * 
	 * @param request to check if client request is authorized
	 * @return list of companies
	 */
	@GetMapping("/get-all-companies")
	public ResponseEntity<List<Company>> getAllCompanies(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCompanies());
	}
	
	/**
	 * Retrieves customer entity from POST request and passes it to respective service to process
	 * 
	 * @param customer to be saved
	 * @param request to check if client request is authorized
	 * @return customer entity saved in database
	 */
	@PostMapping("/save-customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).saveCustomer(customer));
	}
	

	/**
	 * Delete customer based on received customer id
	 * 
	 * @param customerId of customer to be deleted
	 * @param request to check if client request is authorized
	 * @return deleted customer entity
	 */
	@GetMapping("/delete-customer/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).removeCustomer(customerId));
	}

	/**
	 * Get customer based on received customer id
	 * 
	 * @param customerId of customer to be retrieved
	 * @param request to check if client request is authorized
	 * @return retrieved customer entity
	 */
	@GetMapping("/get-customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId, HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getCustomer(customerId));
	}
	
	/**
	 * Retrieve all the customer accounts registered in the system
	 * 
	 * @param request to check if client request is authorized
	 * @return list of customers
	 */
	@GetMapping("/get-all-customers")
	public ResponseEntity<List<Customer>> getAllCustomers(HttpServletRequest request) {
		return ResponseEntity.ok().body(getAdminService(request).getAllCustomers());
	}
	
	/**
	 * Fetches AdminService from SystemService through authorization filter
	 * 
	 * @param request to check if client request is authorized
	 * @return AdminService to use in controller endpoints
	 */
	private AdminService getAdminService(HttpServletRequest request) {
		return (AdminService) systemService.getClient(request);
	}
	 
}
