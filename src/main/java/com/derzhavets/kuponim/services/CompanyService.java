package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;

public interface CompanyService {

	List<Company> getAll();
	
	Company save(Company company);

	Company getById(Long id) throws EntityNotFoundException;

	Company delete(Long id) throws EntityNotFoundException;

}