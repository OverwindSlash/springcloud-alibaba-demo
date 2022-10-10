package com.example.servicec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ServiceCController {
    @GetMapping("/do-c-action/{paramC}")
    public String doCAction(@PathVariable String paramC) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(56);
        return "Service-C.doCAction(" + paramC + ")";
    }
}
