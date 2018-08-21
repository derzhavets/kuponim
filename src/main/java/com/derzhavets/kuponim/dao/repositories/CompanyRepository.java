package com.derzhavets.kuponim.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{
	
	/**
	 * Retrieve all the company entities from the database
	 * 
	 * @return list of found companies
	 */
	List<Company> findAll();
	
	/**
	 * Get all the company entities that match search criteria to check authentication
	 * credentials
	 * 
	 * @param email of the sought company
	 * @param password of the sought company
	 * @return list of found companies matching email and password
	 */
	List<Company> findByEmailAndPassword(String email, String password);
	
}
