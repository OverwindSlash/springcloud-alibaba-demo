package com.example.serviceb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "c-service", url = "127.0.0.1:8082")
public interface ServiceCFeignClient {
    @GetMapping("/do-c-action/{paramC}")
    String doCAction(@PathVariable String paramC);
}
