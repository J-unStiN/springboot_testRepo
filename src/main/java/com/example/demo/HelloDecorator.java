package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HellowService{
    private final HellowService hellowService;

    public HelloDecorator(HellowService hellowService) {
        this.hellowService = hellowService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + hellowService.sayHello(name) + "*";
    }

    @Override
    public int countOf(String name) {
        return hellowService.countOf(name);
    }
}
