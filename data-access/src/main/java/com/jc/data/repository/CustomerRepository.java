package com.jc.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jc.data.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);
	
}
