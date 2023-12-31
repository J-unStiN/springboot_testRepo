package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SimpleHellowService implements HellowService {

    @Override
    public String sayHello(String name) {
        return "Hello boot " + name;
    }
}
