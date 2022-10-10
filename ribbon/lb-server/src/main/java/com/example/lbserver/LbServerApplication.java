package com.example.lbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LbServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LbServerApplication.class, args);
    }
}
