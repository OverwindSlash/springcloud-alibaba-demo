package com.example.sentinelflow.controller;

import com.example.sentinelflow.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class HelloController {

    @Resource
    private MemberService memberService;

    @RequestMapping("/service")
    public String service() {
        return memberService.sayHello();
    }

}
