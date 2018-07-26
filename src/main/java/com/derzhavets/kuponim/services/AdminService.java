package com.derzhavets.kuponim.services;

import java.util.List;

import com.derzhavets.kuponim.entities.Company;
import com.derzhavets.kuponim.entities.Customer;
import com.derzhavets.kuponim.helpers.exceptions.EntityNotFoundException;
import com.derzhavets.kuponim.login.Client;

public interface AdminService extends Client {

	Company saveCompany(Company company);

	Company removeCompany(Long id) throws EntityNotFoundException;

	Company getCompany(Long id) throws EntityNotFoundException;

	List<Company> getAllCompanies();

	Customer saveCustomer(Customer customer);

	Customer removeCustomer(Long id) throws EntityNotFoundException;

	Customer getCustomer(Long id) throws EntityNotFoundException;

	List<Customer> getAllCustomers();

}