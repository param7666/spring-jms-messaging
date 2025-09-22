package com.nt.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class Order implements Serializable{
	
	private int orderId;
	private String customerName;
	private String product;
	private int quantity;

	public Order() {
		System.out.println("Order.Order()");
	}
}
