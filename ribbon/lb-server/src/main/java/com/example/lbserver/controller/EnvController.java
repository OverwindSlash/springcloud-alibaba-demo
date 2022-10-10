package com.example.lbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @Autowired
    Environment environment;

    @GetMapping(value = "/port")
    public String getPort() {
        return environment.getProperty("local.server.port");
    }
}
