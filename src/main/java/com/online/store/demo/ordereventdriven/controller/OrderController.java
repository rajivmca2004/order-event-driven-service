package com.online.store.demo.ordereventdriven.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;
import com.online.store.demo.ordereventdriven.service.OrderService;
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
	private OrderService orderService;
	
	@Autowired
	private OrderEventStreamInputService eventStreamService;


	@PostMapping("/produce")
	public Boolean createOrders(@RequestBody final Message message)
			throws URISyntaxException {
		return  eventStreamService.produceEvent(message);
	}
	
	@GetMapping("/{orderId}")
	public List<PurchaseOrder> getOrderById(String orderId) {
		List<PurchaseOrder> orders = orderService.fetchOrdereDetails(orderId);
		return orders;
	}
}