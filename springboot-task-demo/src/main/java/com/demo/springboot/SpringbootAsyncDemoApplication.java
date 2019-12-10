package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringbootAsyncDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAsyncDemoApplication.class, args);
    }

}
