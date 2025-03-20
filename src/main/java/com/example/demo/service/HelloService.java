package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello() {
        return "Hello, World!";
    }

    public String sayHelloTo(String name) {
        return "Hello, " + name + "!";
    }
}