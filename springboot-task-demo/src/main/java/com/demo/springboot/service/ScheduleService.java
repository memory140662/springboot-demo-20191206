package com.demo.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(
            cron = "0 * * * * * "
    )
    public void hello() {
        System.out.println("Hello...");
    }

}
