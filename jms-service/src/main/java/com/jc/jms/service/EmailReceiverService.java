package com.jc.jms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.jc.jms.dto.Email;

@Service
public class EmailReceiverService {
	
	private static final Logger log = LoggerFactory.getLogger(EmailReceiverService.class);
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        log.info("Received <" + email + ">");
    }
}
