package com.example.apigatewaynacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayNacosApplication.class, args);
    }
}
