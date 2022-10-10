package com.example.sentinelflow.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @SentinelResource(value = "sayHello", fallback = "sayHelloFail")
    public String sayHello() {
        return "Hello, Member! ";
    }

    public String sayHelloFail() {
        return "I am sorry, Member! ";
    }

}
