package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
//@EnableJms
public class BootJmsProj04OrderReciverAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj04OrderReciverAppApplication.class, args);
	}

}
