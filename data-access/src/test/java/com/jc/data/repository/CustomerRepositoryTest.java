package com.jc.data.repository;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

import com.jc.data.entity.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testA_saveSomeCustomers() {

		// save a couple of customers
		customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));
		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));
	}
	
	@Test
	public void testB_getAllCustomers() {

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		Collection<Customer> allCustomers = customerRepository.findAll();
		assertThat(allCustomers.size()).isEqualTo(5);
		for (Customer customer : allCustomers) {
			log.info(customer.toString());
		}
		log.info("");

	}
	
	@Test
	public void testC_getCustomerById() {
		
		Customer customer = customerRepository.getOne(1L);
		log.info("Customer found with getOne(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");
		
		assertThat(customer.getId()).isEqualTo(1L);
		assertThat(customer.getFirstName()).isNotBlank();
		assertThat(customer.getLastName()).isNotBlank();

	}

	@Test
	public void testD_getCustomerByName() {

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		
		List<Customer> bauerCustomers = customerRepository.findByLastName("Bauer");
		assertThat(bauerCustomers.size()).isEqualTo(2);
		bauerCustomers.forEach(bauer -> {
			assertThat(bauer.getId()).isNotNull();
			assertThat(bauer.getLastName()).contains("Bauer");
			log.info(bauer.toString());
		});

		log.info("");
	}
}
