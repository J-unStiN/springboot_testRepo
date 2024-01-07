package com.example.demo;

public interface HellowService {
    String sayHello(String name);

    default int countOf(String name) {
        return 0;
    }
}
