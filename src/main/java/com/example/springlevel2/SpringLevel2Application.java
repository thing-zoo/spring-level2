package com.example.springlevel2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringLevel2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringLevel2Application.class, args);
    }

}
