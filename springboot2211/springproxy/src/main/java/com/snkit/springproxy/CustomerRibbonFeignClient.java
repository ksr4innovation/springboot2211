package com.snkit.springproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@RibbonClient(value="greet-service")
@FeignClient(value="greet-service",name="greet-service")
public interface CustomerRibbonFeignClient {
	
	@GetMapping(value = "/getcust", consumes = { "application/json" },
			produces = { "application/json" })
	public ResponseEntity<String> getCust(@RequestHeader(value="token", required=false) String token
			); 
	
	@GetMapping(value = "/greet/getEmployeeGet",	produces = { "application/json"})
	public ResponseEntity<String> getEmployeeGet();
	
	@GetMapping(value = "/greet/getEmployeeGet2",	produces = { "application/json"})
	public ResponseEntity<String> getEmployeeGet2();

	@GetMapping(value = "/greet/getEmployeeGet3",	produces = { "application/json"})
	public ResponseEntity<String> getEmployeeGet3(@RequestHeader("SSN") String ssn,
			@RequestHeader("orderid") String orderid);
	
}



