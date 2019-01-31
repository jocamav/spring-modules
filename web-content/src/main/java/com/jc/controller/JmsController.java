package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JmsController {
	
	@GetMapping("/jmsexample")
    public String home() {
        return "jms/index";
    }
}
