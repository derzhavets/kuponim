package com.derzhavets.kuponim.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derzhavets.kuponim.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findAll();

	List<Customer> findByNameAndPassword(String name, String password);
}
