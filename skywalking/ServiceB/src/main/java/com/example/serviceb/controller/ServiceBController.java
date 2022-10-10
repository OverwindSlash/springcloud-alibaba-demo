package com.example.serviceb.controller;

import com.example.serviceb.feign.ServiceCFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ServiceBController {
    @Autowired
    ServiceCFeignClient serviceCFeignClient;

    @GetMapping("/do-b-action/{paramB}")
    public String doBAction(@PathVariable String paramB) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(134);
        return "Service-B.doBAction(" + serviceCFeignClient.doCAction(paramB) + ")";
    }
}
