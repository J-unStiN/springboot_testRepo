package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHellowService hellowService = new SimpleHellowService();
        String res = hellowService.sayHello("Test");

        Assertions.assertThat(res).isEqualTo("Hello boot Test");
    }
}
