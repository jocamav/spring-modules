package com.jc.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.jc.jms.dto.Email;

@Service
public class EmailSenderService {

	private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMail(Email email) {

        // Send a message with a POJO - the template reuse the message converter
        log.info("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", email);
	}
}
