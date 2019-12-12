package com.demo.springboot.springbootactuatordemo.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator  {
    @Override
    public Health health() {
//        return  Health.up().withDetail("msg", "OK").build();
        return Health.down().withDetail("msg", "error").build();
    }
}
