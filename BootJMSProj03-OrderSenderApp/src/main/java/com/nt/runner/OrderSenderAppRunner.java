package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.model.*;
import com.nt.service.IOrderService;

@Component
public class OrderSenderAppRunner implements CommandLineRunner{
	
	@Autowired
	private IOrderService ser;

	@Override
	public void run(String... args) throws Exception {
		Order order=new Order(101,"Param","Condom",10);
		String message=ser.sendOrder(order);
		System.out.println(message);
		
	}

	
}
