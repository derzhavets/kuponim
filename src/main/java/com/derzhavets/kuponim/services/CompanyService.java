package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Company;

public interface CompanyService {

	List<Company> getAll();
	
	Company save(Company company);

	Company getById(Long id) throws Exception;

	void delete(Long id);

}