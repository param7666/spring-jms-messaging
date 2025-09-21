package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class BootJmsProj03OrderSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj03OrderSenderAppApplication.class, args);
	}

}
