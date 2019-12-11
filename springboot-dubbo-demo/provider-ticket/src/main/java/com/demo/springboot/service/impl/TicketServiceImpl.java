package com.demo.springboot.service.impl;

import com.demo.springboot.service.TicketService;
import org.apache.dubbo.config.annotation.Service;

@Service
@org.springframework.stereotype.Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<< THE A TEAM >>";
    }
}
