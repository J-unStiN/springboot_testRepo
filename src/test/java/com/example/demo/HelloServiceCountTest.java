package com.example.demo;

import com.example.demo.HelloRepository;
import com.example.demo.HellobootTest;
import com.example.demo.HellowService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {
    @Autowired
    HellowService hellowService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            hellowService.sayHello("sj");
            Assertions.assertThat(helloRepository.countOf("sj")).isEqualTo(count);
        });
    }
}
