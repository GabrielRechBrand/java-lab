package com.github.gabrielrechbrand.javalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class JavaLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLabApplication.class, args);
    }

}
