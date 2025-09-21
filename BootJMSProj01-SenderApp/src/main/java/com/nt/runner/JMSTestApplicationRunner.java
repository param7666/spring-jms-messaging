package com.nt.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component
public class JMSTestApplicationRunner implements CommandLineRunner{
	
	@Autowired
	private JmsTemplate template;

	@Override
	public void run(String... args) throws Exception {
		template.send("testmq1", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message msg=session.createTextMessage("From sender at"+new Date());
				return msg;
			}
		});
		
	}

}
