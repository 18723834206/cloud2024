package com.exam.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainOpenfeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenfeign80.class, args);
    }
}
