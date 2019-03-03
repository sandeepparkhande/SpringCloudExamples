package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
public class AccountServiceApplication {

	@Value("${server.instance.name}")
	private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	
	@RequestMapping("/account")
	@HystrixCommand(fallbackMethod="fallback")
	@ResponseBody
	public HttpEntity<Holding> getAccountHoldings() {	
		Holding holding=new Holding("$10000","$20000", "$30000", "$40000", instance);
		return new HttpEntity<Holding>(holding);
	}
	
	public HttpEntity<Holding> fallback() {
		Holding holding=new Holding("$Account Holdings are not good","$Account Holdings are not good", "$Account Holdings are not good", "$Account Holdings are not good", instance);
		return new HttpEntity<Holding>(holding);
	}

}

