package com.derzhavets.kuponim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.services.CompanyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/companies")
public class CompaniesController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public List<Company> getAll() {
		return companyService.getAll();
	}
	
	@GetMapping("/{id}")
	public Company getOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		return companyService.getById(id);
	}
	
	@PostMapping("/")
	public Company save(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@DeleteMapping("/{id}")
	public Company delete(@PathVariable("id") Long id) throws EntityNotFoundException {
		return companyService.delete(id);
	}

}
