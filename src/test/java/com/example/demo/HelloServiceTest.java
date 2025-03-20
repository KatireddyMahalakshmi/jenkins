package com.example.demo;


import com.example.demo.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testSayHello() {
        assertEquals("Hello, World!", helloService.sayHello());
    }

    @Test
    public void testSayHelloTo() {
        assertEquals("Hello, John!", helloService.sayHelloTo("John"));
    }
}