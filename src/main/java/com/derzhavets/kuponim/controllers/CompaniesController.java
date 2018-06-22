package com.derzhavets.kuponim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public List<Company> getAll() {
		return companyService.getAll();
	}
	
	@PostMapping("/")
	public Company save(@RequestBody Company company) {
		return companyService.save(company);
	}

}
