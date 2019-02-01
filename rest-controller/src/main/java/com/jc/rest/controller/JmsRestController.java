package com.jc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.jms.dto.Email;
import com.jc.jms.service.EmailSenderService;

@RestController
@RequestMapping("/api/jms")
public class JmsRestController {
	
	@Autowired
	private EmailSenderService emailSenderService;

    @PostMapping
    public Email sendMail(@RequestBody Email email) {
        emailSenderService.sendMail(email);
        return email;
    }
}
