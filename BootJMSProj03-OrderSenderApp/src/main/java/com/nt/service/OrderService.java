package com.nt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.nt.config.JmsConfig;
import com.nt.model.Order;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private JmsTemplate template;
	@Autowired
	private JmsConfig config;

	@Override
	public String sendOrder(Order order) {
		
		//AT THE TIME OF SENDING OBJECT IT GIVES YOU EXCEPTION OF CONVERTION STRING TO OBJECT
		
//		template.send(config.orderQueueName, new MessageCreator() {
//			
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				Message msgMessage=session.createTextMessage("Message from Sender App at "+""+new Date()+" "+order);
//				return msgMessage;
//			}
//		});
		
		template.convertAndSend(config.orderQueueName, order);
		System.out.println("Message sent "+order);
		return "Message sent "+order;
	}
	
	

}
