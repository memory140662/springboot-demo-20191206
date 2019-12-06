package com.demo.springboot;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Optional;

@SpringBootTest
@RequiredArgsConstructor
public class SpringCacheApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> redisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeRepository.findEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void test01() {
//        stringRedisTemplate.keys("*").forEach(System.out::println);
//        stringRedisTemplate.opsForValue().append("msg", "Hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

//        stringRedisTemplate.opsForList().leftPush("mylist", "1");
//        stringRedisTemplate.opsForList().leftPush("mylist", "2");
//        stringRedisTemplate.opsForList().leftPush("mylist", "3");
    }

    @Test
    public void test02() {
//        Employee employee = employeeRepository.findEmployeeById(1);
//        redisTemplate.opsForValue().set("emp-01", employee);
        Employee employee = (Employee) redisTemplate.opsForValue().get("emp-01");
        System.out.println(employee);
    }
}
