package com.online.store.demo.ordereventdriven.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;

/**
 * @author rasrivastava
 *
 */

@Service
public class OrderServiceImpl implements OrderService {

	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public List<Object> createOrdereDetails(String orderId, PurchaseOrder purchaseOrder) {
		return null;
	}


	@Override
	public List<PurchaseOrder> fetchOrdereDetails(String orderId) {
		return null;
	}

}
