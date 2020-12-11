package com.online.store.demo.ordereventdriven.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class OrderEventStreamInputService {
	
		@Autowired
		private OrderEventStream eventStream;

		public Boolean produceEvent(Message msg) {
			System.out.println("Producing order events=> id: "+ msg.getId() +" Actual message: "+ msg.getData());
			msg.setBytePayload(msg.getData().getBytes());
			MessageChannel messageChannel = eventStream.producer();
			return messageChannel.send(MessageBuilder.withPayload(msg)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		}
}