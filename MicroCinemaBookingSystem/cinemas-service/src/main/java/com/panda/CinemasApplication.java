package com.panda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.panda.feign.clients")
@SpringBootApplication
public class CinemasApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinemasApplication.class, args);
    }
}

