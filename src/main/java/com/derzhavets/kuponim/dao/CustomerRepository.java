package com.derzhavets.kuponim.dao;

import org.springframework.data.repository.CrudRepository;

import com.derzhavets.kuponim.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
