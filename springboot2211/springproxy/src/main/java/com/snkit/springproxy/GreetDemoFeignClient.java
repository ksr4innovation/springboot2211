package com.snkit.springproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value="greetdemo",url="http://localhost:52872/")
public interface GreetDemoFeignClient {
	@GetMapping(value = "greet/getEmployeeGet",  produces = { "application/json"})
	public String getEmployeeGet();
}
