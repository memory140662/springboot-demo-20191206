package com.demo.springboot;

import com.demo.springboot.bean.Book;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashMap;

@SpringBootTest
class SpringbootAmqpDemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        val exchange = "exchange.direct";
        val routeKey = "demo.news";
        val message = new HashMap<String, Object>();
        message.put("msg", "my first message");
        message.put("data", Collections.singletonList("Hello"));
//        rabbitTemplate.convertAndSend(exchange, routeKey, message);
        rabbitTemplate.convertAndSend(exchange, routeKey, new Book("Java", "Leo"));
    }


    @Test
    public void receive() {
        val routeKey = "demo.news";
        val data = rabbitTemplate.receiveAndConvert(routeKey);
        System.out.println(data.getClass());
        System.out.println(data);
    }

    @Test
    public void sendMessage() {
        val exchange = "exchange.fanout";
        rabbitTemplate.convertAndSend(exchange, "", new Book("Three pigs", "D~"));
    }

    @Test
    public void createExchange() {
        val exchange = new DirectExchange("amqpadmin.exchange");
        amqpAdmin.declareExchange(exchange);
    }

    @Test
    public void createQueue() {
        val queue = new Queue("amqpadmin.exchange", true);
        amqpAdmin.declareQueue(queue);
    }

    @Test
    public void createBind() {
        val binding = new Binding("amqpadmin.exchange", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null);
        amqpAdmin.declareBinding(binding);
    }
}
