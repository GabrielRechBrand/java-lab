package com.github.gabrielrechbrand.javalab;

import org.springframework.boot.SpringApplication;

public class TestJavaLabApplication {

    public static void main(String[] args) {
        SpringApplication.from(JavaLabApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
