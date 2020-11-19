package com.snkit.springproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="employedemo",value="employedemo",url="http://localhost:52735")
public interface CustomerDemoFeignClient {
	@GetMapping(value = "/getEmployeInterface")
	public String getEmployeInterface();
}
