package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
public class TradeServiceApplication {

	@Value("${server.instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceApplication.class, args);
	}
	
	@RequestMapping("/")
	@HystrixCommand(fallbackMethod="fallback")
	public String getTrade() {
		
		return " Tesla is new Good" + instance;
	}
	
	public String fallback() {
		
		return "All Well";
	}
}
