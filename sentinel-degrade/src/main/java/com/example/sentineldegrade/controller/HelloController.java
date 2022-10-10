package com.example.sentineldegrade.controller;

import com.example.sentineldegrade.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping
public class HelloController {

    @Resource
    private MemberService memberService;

    @RequestMapping("/service")
    public String service() throws InterruptedException {
        //TimeUnit.MILLISECONDS.sleep(400);
        return memberService.sayHello();
    }

}
