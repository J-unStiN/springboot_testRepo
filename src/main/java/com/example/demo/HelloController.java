package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


@RequestMapping("/hello")
public class HelloController {

    private final HellowService hellowService;

    public HelloController(HellowService hellowService) {
        this.hellowService = hellowService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        return hellowService.sayHello(Objects.requireNonNull(name));
    }
}
