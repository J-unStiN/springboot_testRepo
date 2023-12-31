package com.example.demo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }


    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("sj")).isNull();
    }

    @Test
    void incraseCount() {
        Assertions.assertThat(helloRepository.countOf("sj")).isEqualTo(0);

        helloRepository.increaseCount("sj");
        Assertions.assertThat(helloRepository.countOf("sj")).isEqualTo(1);

        helloRepository.increaseCount("sj");
        Assertions.assertThat(helloRepository.countOf("sj")).isEqualTo(2);
    }
}
