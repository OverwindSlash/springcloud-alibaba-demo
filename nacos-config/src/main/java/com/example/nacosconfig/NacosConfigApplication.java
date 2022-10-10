package com.example.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication {

    private static ConfigurableApplicationContext context;

    @RestController
    public class NacosController {
        @Value("${db.address}")
        private String dbAddress;

        @RequestMapping("/get")
        public String get() {
            return "Database Address(@Value): " + dbAddress + "\n" +
                   "Database Address(context): "  + context.getEnvironment().getProperty("db.address");
        }
    }

    public static void main(String[] args) {
        context = SpringApplication.run(NacosConfigApplication.class, args);

        String address = context.getEnvironment().getProperty("db.address");
        String username = context.getEnvironment().getProperty("db.username");
        String password = context.getEnvironment().getProperty("db.password");

        System.err.println("Database Address :" + address +
                "; User: " + username + "; Password: " + password);
    }

}
