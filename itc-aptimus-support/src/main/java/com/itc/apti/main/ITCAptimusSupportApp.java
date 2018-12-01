package com.itc.apti.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.itc.apti.*")
public class ITCAptimusSupportApp {

    public static void main(String[] args) {
        SpringApplication.run(ITCAptimusSupportApp.class, args);
    }
}
