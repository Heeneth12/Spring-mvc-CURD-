package com.telusk.springbootstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.telusk.springbootstudents"})
public class SpringbootStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudentsApplication.class, args);
    }



}
