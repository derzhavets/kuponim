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
