package com.example.lbclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class ClientController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/lb-server")
    public String getResponseManualLb() {
        // 从nacos中获取服务
        List<ServiceInstance> instances = discoveryClient.getInstances("env-service");
        // 定义一个随机数
        int index = new Random().nextInt(instances.size());
        // 随机获取一个服务
        ServiceInstance serviceInstance = instances.get(index);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        String response = restTemplate
                .getForObject("http://"+url+"/port", String.class);

        return "Response from port: " + response;
    }

    @GetMapping("/lb-server-ribbon")
    public String getResponseRibbonLb() {
        String response = restTemplate
                .getForObject("http://env-service/port", String.class);

        return "（Ribbon）Response from port: " + response;
    }
}


