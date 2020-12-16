package com.online.store.demo.ordereventdriven.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.online.store.demo.ordereventdriven.model.PurchaseOrder;

@Service
public class OrderEventProducerStreamService {
	
		@Autowired
		private OrderEventProducerStream eventStream;

		public Boolean produceEvent(PurchaseOrder msg) {
			System.out.println("Producing purchase order events=> id: "+ msg.getId() +" Actual message: "+ msg.getData());
			msg.setBytePayload(msg.getData().getBytes());
			MessageChannel messageChannel = eventStream.producer();
			return messageChannel.send(MessageBuilder.withPayload(msg)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		}
}