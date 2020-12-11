package com.online.store.demo.ordereventdriven.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderEventStream.class)
public class OrderEventStreamConfig {

}
