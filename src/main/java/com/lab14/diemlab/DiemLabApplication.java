package com.lab14.diemlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DiemLabApplication {

    public static void main(String[] args) {

        SpringApplication.run(DiemLabApplication.class, args);
        System.out.println("Running ...");
    }

}
