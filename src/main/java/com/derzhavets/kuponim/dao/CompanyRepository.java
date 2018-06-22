package com.derzhavets.kuponim.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.derzhavets.kuponim.entities.Company;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	
	List<Company> findAll();
	
	<C extends Company> C save(Company company);
	
}
