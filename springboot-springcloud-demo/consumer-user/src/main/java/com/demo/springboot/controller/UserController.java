package com.demo.springboot.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class UserController {

    @NonNull RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name) {
        String ticket = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name + " buy " + ticket;
    }
}
