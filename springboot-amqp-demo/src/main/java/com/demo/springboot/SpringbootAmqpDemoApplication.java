package com.demo.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SpringbootAmqpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmqpDemoApplication.class, args);
    }

}
