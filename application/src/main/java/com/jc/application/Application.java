package com.jc.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.library.service.MyService;

@SpringBootApplication(scanBasePackages = "com.jc")
@RestController
public class Application {

	@Autowired
	MyService myService;
	
	@GetMapping("/")
    public String home() {
        return myService.message();
    }
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
