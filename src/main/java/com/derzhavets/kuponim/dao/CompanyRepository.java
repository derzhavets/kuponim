package com.derzhavets.kuponim.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{
	
	List<Company> findAll();
	
}
