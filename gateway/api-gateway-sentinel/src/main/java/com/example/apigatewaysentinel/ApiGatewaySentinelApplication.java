package com.example.apigatewaysentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewaySentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewaySentinelApplication.class, args);
    }
}
