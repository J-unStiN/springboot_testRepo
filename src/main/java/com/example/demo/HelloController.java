package com.example.demo;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
public class HelloController {

    private final HellowService hellowService;

    public HelloController(HellowService hellowService) {
        this.hellowService = hellowService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return hellowService.sayHello(Objects.requireNonNull(name));
    }
}
