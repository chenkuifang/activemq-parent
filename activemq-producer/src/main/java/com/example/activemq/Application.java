package com.example.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
//@EnableJms
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        String[] beans = context.getBeanDefinitionNames();

        for (String obj : beans) {
            System.err.println("bean:" + obj);
        }
    }
}
