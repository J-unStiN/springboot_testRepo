package com.example.demo;


import java.util.Objects;

public class HelloController {

    private final HellowService hellowService;

    public HelloController(HellowService hellowService) {
        this.hellowService = hellowService;
    }

    public String hello(String name) {
        return hellowService.sayHello(Objects.requireNonNull(name));
    }
}
