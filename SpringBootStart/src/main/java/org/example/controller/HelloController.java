package org.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloController
 * @date: 2020/4/25 15:47
 * @author: Finallap
 * @version: 1.0
 */
@RestController
@SpringBootApplication(exclude = {})
public class HelloController {
    @GetMapping("show")
    public String test() {
        return "Hello Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}
