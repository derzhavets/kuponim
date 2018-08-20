package com.derzhavets.kuponim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derzhavets.kuponim.dao.CompanyDao;
import com.derzhavets.kuponim.dao.CustomerDao;
import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.entities.KuponimUser;
import com.derzhavets.kuponim.helpers.ClientType;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.helpers.exceptions.UserNotFoundException;
import com.derzhavets.kuponim.services.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public KuponimUser login(String email, String password) 
		throws UserNotFoundException {
		if (!email.equals("admin") || !password.equals("1234"))
			throw new UserNotFoundException("Admin username or password incorrect.");
		return new KuponimUser(1L, "Admin", "admin@mail.com", ClientType.ADMIN);
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
	public Customer removeCustomer(Long id) throws EntityNotFoundException {
		return customerDao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see com.derzhavets.kuponim.services.AdminService#getCustomer(java.lang.Long)
	 */
	@Override
	public Customer getCustomer(Long id) throws EntityNotFoundException {
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
