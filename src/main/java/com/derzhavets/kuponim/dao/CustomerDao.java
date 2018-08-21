package com.derzhavets.kuponim.dao;

import java.util.List;

import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CustomerRepository;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;

@Service
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	/**
	 * Get all the customers registered in the system
	 * 
	 * @return list of customer entities found in the database
	 */
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}
	
	/**
	 * Retrieve customer entity based on customer id
	 * 
	 * @param id of the customer to be retrieved from the database
	 * @return found customer entity
	 * @throws EntityNotFoundException in case customer with received id is not found in the 
	 * database
	 */
	public Customer getById(Long id) throws EntityNotFoundException {
		return customerRepo.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Customer with id " + id + " is not found."));
	}
	
	/**
	 * Pass customer entity to be saved to the customer repository
	 * 
	 * @param customer to be saved
	 * @return saved customer entity
	 */
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}
	
	/**
	 * Delete customer entity based on customer id
	 * 
	 * @param id of the customer to be deleted from the database
	 * @return deleted customer entity
	 * @throws EntityNotFoundException in case customer with received id is not found in the 
	 * database
	 */
	public Customer delete(Long id) throws EntityNotFoundException {
		Customer customer = getById(id);
		customerRepo.delete(customer);
		return customer;
	}

	/**
	 * Looking for a customer entity in the database matching received credentials to perform
	 * customer user authentication
	 * 
	 * @param email of the customer user
	 * @param password of the customer user
	 * @return KuponimUser entity with found customer credentials
	 * @throws UserNotFoundException in case there were no customer found in the database with
	 * provided credentials
	 */
	public KuponimUser getCustomerUser(String email, String password) throws UserNotFoundException {
		List<Customer> customers = customerRepo.findByEmailAndPassword(email, password);
		if (customers.isEmpty()) {
			throw new UserNotFoundException("Customer email or password incorrect");
		} else {
			Customer customer = customers.get(0);
			return new KuponimUser(customer.getId(), customer.getName(), customer.getEmail(), ClientType.CUSTOMER);
		}
	}
}
