package com.example.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


/**
 * Producer
 *
 * @author QuiFar
 */
@Component
public class Producer {

    private JmsMessagingTemplate jmsMessagingTemplate;

    public Producer(JmsMessagingTemplate jmsMessagingTemplate) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
    }


    /**
     * 往消息队列里发送消息
     *
     * @param destination 消息队列
     * @param msg         发送的消息
     */
    public void send(Destination destination, String msg) {
        this.jmsMessagingTemplate.convertAndSend(destination, msg);
    }

}
