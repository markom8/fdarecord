package com.assignment.fdarecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.assignment.fdarecord"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
