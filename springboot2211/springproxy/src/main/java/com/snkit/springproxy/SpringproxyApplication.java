package com.snkit.springproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringproxyApplication {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/*
	 * @Bean public CustomFeignInterceptor customFeignInterceptor() { return new
	 * CustomFeignInterceptor();
	 * 
	 * }
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringproxyApplication.class, args);
	}

}
