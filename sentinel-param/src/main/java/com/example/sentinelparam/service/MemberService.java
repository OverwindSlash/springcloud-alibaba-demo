package com.example.sentinelparam.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @SentinelResource(value = "sayHello", fallback = "sayHelloFail")
    public String sayHello(String name) {
        return "Hello, Member! " + name;
    }

    public String sayHelloFail(String name) {
        return "I am sorry, Member! " + name;
    }

}
