package com.jc.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.jc.jms.dto.Email;
import com.jc.jms.service.EmailSenderService;

@SpringBootApplication
public class JmsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(JmsApplication.class);
	
    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(JmsApplication.class, args);

        EmailSenderService emailSenderService = context.getBean(EmailSenderService.class);

        // Send a message with a POJO - the template reuse the message converter
        log.info("Sending an email message.");
        emailSenderService.sendMail(new Email("info@example.com", "Hello"));
    }

}
