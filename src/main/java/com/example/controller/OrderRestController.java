package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.AppConstents;
import com.example.model.Order;

@RestController
public class OrderRestController {
	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order)
	{
		kafkaTemplate.send(AppConstents.TOPIC,order);
		return"Order Placed";
	}

}
