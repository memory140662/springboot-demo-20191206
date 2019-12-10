package com.demo.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SpringbootAsyncDemoApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String username;

    @Value("#{environment.TARGET_MAIL}")
    String to;

    @Test
    void contextLoads() {
        System.out.println("Send Mail from " + username + " to " + to);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知1");
        mailMessage.setText("Hello ");
        mailMessage.setTo(to);
        mailMessage.setFrom(username);

        javaMailSender.send(mailMessage);
    }

}
