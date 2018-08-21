package com.derzhavets.kuponim.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	/**
	 * Retrieve all the customer entities from the database
	 * 
	 * @return list of found customers
	 */
	List<Customer> findAll();
	
	/**
	 * Get all the customer entities that match search criteria to check authentication
	 * credentials
	 * 
	 * @param email of the sought customer
	 * @param password of the sought customer
	 * @return list of found customers matching email and password
	 */
	List<Customer> findByEmailAndPassword(String email, String password);
}
