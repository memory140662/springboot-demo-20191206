package com.demo.springboot.service;

import com.demo.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = {"demo.news"})
    public void receive(Book book) {
        System.out.println("Received: " + book);
    }

    @RabbitListener(queues = {"demo"})
    public void receiveWithHeader(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
