package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSpringCloudApplication.class, args);
	}
	
	@Bean
	public ZFilter zFilter() {
		return new ZFilter();
	}
}
