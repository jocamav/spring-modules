package com.jc.rest.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.data.entity.Customer;
import com.jc.data.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Customer getSingleCustomer(@PathVariable Long id) {
        return customerRepository.getOne(id);
    }
}
