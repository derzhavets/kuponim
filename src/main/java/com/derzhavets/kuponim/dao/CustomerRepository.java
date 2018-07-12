package com.derzhavets.kuponim.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
