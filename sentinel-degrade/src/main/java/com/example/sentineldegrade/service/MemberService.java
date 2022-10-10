package com.example.sentineldegrade.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MemberService {

    @SentinelResource(value = "sayHello", fallback = "sayHelloFail")
    public String sayHello() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(400);
        return "Hello, Member! ";
    }

    public String sayHelloFail() {
        return "I am sorry, Member! ";
    }

    public String blockHandler(BlockException e) {
        return "Blocked! I am sorry, Member!";
    }

}
