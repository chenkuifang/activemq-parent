package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author QuiFar
 */
@Component
public class Consumer {
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "my.queue")
	public void receiveQueue(String text) {
		System.err.println("消费者接收到的信息：." + text);
	}
}
