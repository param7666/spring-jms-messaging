package com.nt.reciver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSMessageConsumer {
	
	@JmsListener(destination = "testmq1")
	public void readMessage(String text) {
		System.out.println("Recvived message:: "+text);
	}

}
