package com.example.demo;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
    private final ApplicationContext applicationContext;

    public HelloController(HellowService hellowService, ApplicationContext applicationContext) {
        this.hellowService = hellowService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return hellowService.sayHello(Objects.requireNonNull(name));
    }

}
