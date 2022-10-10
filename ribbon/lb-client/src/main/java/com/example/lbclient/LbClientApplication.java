package com.example.lbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class LbClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(LbClientApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
