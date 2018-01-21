package com.example.activemq;

import com.example.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/***
 * index controller
 * @author QuiFar
 */
@RestController
public class IndexController {
    @Autowired
    private Producer producer;

    @GetMapping("/index")
    public String index() {
        Destination destination = new ActiveMQQueue("my.queue");
        for (int i = 0; i < 10; i++) {
            producer.send(destination, "hi quifar" + (i + 1));
        }
        return "send 10 times message";
    }
}
