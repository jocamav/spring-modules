package com.jc.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);
	
}
