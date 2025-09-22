package com.nt.reciver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.nt.model.*;

@Component
public class OrderReciver {
	
	@JmsListener(destination = "orders-queue")
	public void reciverOrder(Order order) {

		System.out.println("Order Came from sender App"+order);

	}
}
