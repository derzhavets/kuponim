package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyDao;
import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.UserNotFoundException;
import com.derzhavets.kuponim.login.Client;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public Client login(String name, String password, ClientType clientType) 
			throws UserNotFoundException {
		
		if (name == "admin" && password == "1234") 
			return this;
		else 
			throw new UserNotFoundException("Admin username or password incorrect.");
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#createCompany(com.derzhavets.kuponim.entities.Company)
	 */
	@Override
	public Company saveCompany(Company company) {
		return companyDao.save(company);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#removeCompany(java.lang.Long)
	 */
	@Override
	public Company removeCompany(Long id) throws EntityNotFoundException {
		return companyDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getCompany(java.lang.Long)
	 */
	@Override
	public Company getCompany(Long id) throws EntityNotFoundException {
		return companyDao.getById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getAllCompanies()
	 */
	@Override
	public List<Company> getAllCompanies() {
		return companyDao.getAll();
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#createCustomer(com.derzhavets.kuponim.entities.Customer)
	 */
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#removeCustomer(java.lang.Long)
	 */
	@Override
	public Customer removeCustomer(Long id) {
		return customerDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getCustomer(java.lang.Long)
	 */
	@Override
	public Customer getCustomer(Long id) {
		return customerDao.getById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAll();
	}

}
