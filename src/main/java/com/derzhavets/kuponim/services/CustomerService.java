package com.derzhavets.kuponim.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.derzhavets.kuponim.entities.Customer;

public interface CustomerService {

	List<Customer> getAll();

	Customer getById(Long id) throws EntityNotFoundException;

	Customer save(Customer customer);

	Customer delete(Long id) throws EntityNotFoundException;

}