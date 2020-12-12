package com.online.store.demo.ordereventdriven.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.ordereventdriven.stream.Message;
import com.online.store.demo.ordereventdriven.stream.OrderEventStreamInputService;

/**
 * @author rasrivastava
 * @apiNote Order event driven Micro-Service
 */
@RestController
@RequestMapping("/orders")
public class OrderController {


	@Autowired
	private OrderEventStreamInputService eventStreamService;

	@PostMapping("/produce")
	public Boolean createOrders(@RequestBody final Message message) throws URISyntaxException {
		return eventStreamService.produceEvent(message);
	}
}