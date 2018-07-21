package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.EntityNotFoundException;
import com.derzhavets.kuponim.login.Client;

public interface AdminService extends Client {

	Company createCompany(Company company);

	Company removeCompany(Long id) throws EntityNotFoundException;

	Company updateCompany(Company company);

	Company getCompany(Long id) throws EntityNotFoundException;

	List<Company> getAllCompanies();

	Customer createCustomer(Customer customer);

	Customer removeCustomer(Long id);

	Customer updateCustomer(Customer customer);

	Customer getCustomer(Long id);

	List<Customer> getAllCustomers();

}