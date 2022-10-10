package com.example.servicea.controller;

import com.example.servicea.feign.ServiceBFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ServiceAController {
    @Autowired
    private ServiceBFeignClient serviceBClient;

    @GetMapping("business/{param}")
    public String doBusiness(@PathVariable String param) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(253);
        return "Service-A.doBusiness(" + serviceBClient.doBAction(param) + ")";
    }

    @GetMapping("test")
    public String test() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(253);
        return "test";
    }
}
