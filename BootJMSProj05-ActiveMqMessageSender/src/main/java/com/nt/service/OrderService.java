package com.nt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.nt.config.JmsConfig;
import com.nt.model.Order;


@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private JmsTemplate template;
	@Autowired
	private JmsConfig config;

	@Scheduled(cron = "*/10 * * * * *")
	@Override
	public String sendOrder() {
		
		Order order=new Order(102,"Param","Laptop",4);
		
		template.convertAndSend(config.orderQueueName, order );
		System.out.println("Message sent "+order);
		return "Message sent "+order;
	}
	
	

}
