package com.springboot.serverevents;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Lombok annotation
// Causes lombok to generate a logger field.
@Slf4j
// Spring framework annotation
// Main implementation class which serves two purpose in a spring boot application: Configuration and bootstrapping.
@SpringBootApplication
public class SpringbootServerEvents {

	// Main program to start up the spring boot application.
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerEvents.class, args);
        log.info("Spring-boot server events application started successfully.");
    }
}
