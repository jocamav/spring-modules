package com.jc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jc.data.entity.Customer;
import com.jc.data.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customerajax")
    public String customerAjax() {
        return "customer/customerajax";
    }
	
	@GetMapping("/customer")
    public String customerList(Model model) {
		List<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers", customers);
        return "customer/customer";
    }
}
