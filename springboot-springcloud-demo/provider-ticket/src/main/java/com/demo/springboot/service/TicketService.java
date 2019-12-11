package com.demo.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket() {
        return "This is a ticket";
    }
}
