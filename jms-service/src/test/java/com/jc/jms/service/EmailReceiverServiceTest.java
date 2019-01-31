package com.jc.jms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jc.jms.dto.Email;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmailReceiverService.class})
public class EmailReceiverServiceTest {

	@Autowired
	private EmailReceiverService emailReceiverService;
	
	@Test
	public void receiveMessageTest() {
		Email email = new Email("info@example.com", "Hello");
		emailReceiverService.receiveMessage(email);
		
	}
}
