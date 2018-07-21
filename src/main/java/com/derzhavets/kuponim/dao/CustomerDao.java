package com.derzhavets.kuponim.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.repositories.CustomerRepository;
import com.derzhavets.kuponim.entities.Customer;

@Service
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerDao;
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getAll()
	 */
	public List<Customer> getAll() {
		return customerDao.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#getById(java.lang.Long)
	 */
	public Customer getById(Long id) throws EntityNotFoundException {
		return customerDao.findById(id).orElseThrow(() -> 
			new EntityNotFoundException("Customer with id " + id + " is not found."));
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#save(com.derzhavets.kuponim.entities.Customer)
	 */
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.CustomerService#delete(java.lang.Long)
	 */
	public Customer delete(Long id) throws EntityNotFoundException {
		Customer customer = getById(id);
		customerDao.delete(customer);
		return customer;
	}
}
