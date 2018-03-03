package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DiscoveryClientApplication {

	@Autowired
	EurekaClient client;
	
	@Autowired
	RestTemplateBuilder builder;
	
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryClientApplication.class, args);
	}
	
	@RequestMapping("/tradeEureka")
	public String home() {
		RestTemplate restTemplate=builder.build();
		InstanceInfo instanceInfo=client.getNextServerFromEureka("TradeService", false);
		String baseURL=instanceInfo.getHomePageUrl();
		ResponseEntity<String> response=restTemplate.getForEntity(baseURL,String.class);
		return response.getBody();
	}
	
	
}
