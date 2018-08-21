package com.derzhavets.kuponim.services.api;

import java.util.List;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.Client;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

public interface AdminService extends Client {
	
	/**
	 * Create and save new company to the system
	 * 
	 * @param company entity to be saved
	 * @return company entity saved
	 */
	Company saveCompany(Company company);
	
	/**
	 * Delete company from the system
	 * 
	 * @param id of the company to be deleted
	 * @return company entity deleted
	 * @throws EntityNotFoundException in case of company with provided id was not found
	 */
	Company removeCompany(Long id) throws EntityNotFoundException;

	/**
	 * Get company with provided id
	 * 
	 * @param id of the company to retrieve
	 * @return company entity
	 * @throws EntityNotFoundException in case company entity with proided id was not found
	 */
	Company getCompany(Long id) throws EntityNotFoundException;
	
	/**
	 * Get all the companies registered in the system
	 * 
	 * @return list of company entities
	 */
	List<Company> getAllCompanies();

	/**
	 * Create and save new customer to the system
	 * 
	 * @param customer entity to be saved
	 * @return customer entity saved
	 */
	Customer saveCustomer(Customer customer);
	
	/**
	 * Delete customer from the system
	 * 
	 * @param id of the customer to be deleted
	 * @return customer entity deleted
	 * @throws EntityNotFoundException in case of customer with provided id was not found
	 */
	Customer removeCustomer(Long id) throws EntityNotFoundException;

	/**
	 * Get customer with provided id
	 * 
	 * @param id of the customer to retrieve
	 * @return customer entity
	 * @throws EntityNotFoundException in case customer entity with proided id was not found
	 */
	Customer getCustomer(Long id) throws EntityNotFoundException;

	/**
	 * Get all the customers registered in the system
	 * 
	 * @return list of customer entities
	 */
	List<Customer> getAllCustomers(); 

}