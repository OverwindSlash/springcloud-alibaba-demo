package com.example.nacosconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {

	@RestController
	public class NacosController{
		@Autowired
		private LoadBalancerClient loadBalancerClient;
		@Autowired
		private DiscoveryClient discoveryClient;
		@Autowired
		private RestTemplate restTemplate;
		@Value("${spring.application.name}")
		private String appName;

		@GetMapping("/echo/app-name")
		public String echoAppName(){
			//使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
			ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
			String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(),
					serviceInstance.getPort(), appName);
			System.out.println("request url:"+url);
			return restTemplate.getForObject(url, String.class);
		}

		@GetMapping("/echo/app-name-client")
		public String echoAppNameUsingDiscoveryClient(){
			List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
			if (instances.size() != 0)
			{
				ServiceInstance serviceInstance = instances.get(0);
				String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(),
						serviceInstance.getPort(), appName);
				System.out.println("request url:"+url);
				return restTemplate.getForObject(url, String.class);
			}

			return "";
		}
	}

	//实例化 RestTemplate 实例
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerApplication.class, args);
	}
}
