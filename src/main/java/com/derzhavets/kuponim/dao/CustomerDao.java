package com.derzhavets.kuponim.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CustomerRepository;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.UserNotFoundException;

@Service
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAll()
	 */
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getById(java.lang.Long)
	 */
	public Customer getById(Long id) throws EntityNotFoundException {
		return customerRepo.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Customer with id " + id + " is not found."));
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#save(com.derzhavets.kuponim.entities.Customer)
	 */
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#delete(java.lang.Long)
	 */
	public Customer delete(Long id) throws EntityNotFoundException {
		Customer customer = getById(id);
		customerRepo.delete(customer);
		return customer;
	}

	public void checkCustomerUser(String name, String password) throws UserNotFoundException {
		List<Customer> customers = customerRepo.findByNameAndPassword(name, password);
		if (customers.isEmpty()) 
			throw new UserNotFoundException("Customer name or password incorrect");
	}
}
