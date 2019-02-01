package com.jc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jc.data.entity.Customer;
import com.jc.data.repository.CustomerRepository;

@SpringBootApplication
public class WebApplication {

	private static final Logger log = LoggerFactory.getLogger(WebApplication.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		List<Customer> customers = customerRepository.findAll();
		if(customers.size() > 0 ) {
			log.info("There are some customers already created");
		}
		else {
			log.info("No customers created, we need to create some test data");
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));
		}
    }
}
