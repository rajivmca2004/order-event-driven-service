package com.online.store.demo.ordereventdriven.service;

import java.util.List;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;

public interface OrderService {

	
	List<Object> createOrdereDetails(String orderId, PurchaseOrder purchaseOrder);

	List<PurchaseOrder> fetchOrdereDetails(String orderId);
}
