package com.example.demo;

public class SimpleHellowService implements HellowService {

    @Override
    public String sayHello(String name) {
        return "Hello boot " + name;
    }
}
