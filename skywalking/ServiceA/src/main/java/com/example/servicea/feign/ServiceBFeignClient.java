package com.example.servicea.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "b-service", url = "127.0.0.1:8081")
public interface ServiceBFeignClient {
    @GetMapping("/do-b-action/{paramB}")
    String doBAction(@PathVariable String paramB);
}