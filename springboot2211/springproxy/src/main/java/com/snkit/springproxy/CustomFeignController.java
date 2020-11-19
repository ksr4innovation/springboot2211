package com.snkit.springproxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomFeignController {

	@Autowired
	CustomerDemoFeignClient customerDemoFeignClient;

	@Autowired
	GreetDemoFeignClient greetDemoFeignClient;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	CustomerRibbonFeignClient customerRibbonFeignClient;

	@GetMapping(value = "/getEmployeInterface")
	public EmployeInfo getEmployeInterface() {
		EmployeInfo emp = new EmployeInfo();

		// CompletetalFuture cust

		emp.setEmp(customerDemoFeignClient.getEmployeInterface());
		emp.setGreet(greetDemoFeignClient.getEmployeeGet());

		return emp;
	}

	@GetMapping(value = "/getEmployeInterfaceByRibbon")
	public EmployeInfo getEmployeInterfaceByRibbon() {
		EmployeInfo emp = new EmployeInfo();

		// CompletetalFuture cust

		emp.setEmp(customerDemoFeignClient.getEmployeInterface());
		emp.setGreet(greetDemoFeignClient.getEmployeeGet());

		return emp;
	}

	@GetMapping(value = "/getGreetserviceInstance")
	public List<String> getCustomerInstance() {
		System.out.println(" Entring into GreetService  CustomFeignController ");
		List<String> services = new ArrayList();
		List<ServiceInstance> serviceInstance = discoveryClient.getInstances("greet-service");
		serviceInstance.forEach(instance -> {
			System.out.println(instance.getHost() + ":" + instance.getPort());
			services.add(instance.getHost() + ":" + instance.getPort());
		});

		System.out.println(" Exist from  getcustribbon  CustomFeignController ");
		return services;
	}

	@GetMapping(value = "/getServices")
	public List<String> getServices() {
		System.out.println(" Entring into getServices  CustomerProxyController ");
		List<String> serviceInstance = discoveryClient.getServices();
		serviceInstance.forEach(instance -> {
			System.out.println(instance);
		});

		System.out.println(" Exist from  getServices  CustomerProxyController ");
		return serviceInstance;

	}

	@GetMapping(value = "/getEmpRibbonfeign")
	public String getcustribbonfeign() {
		ResponseEntity<String> response = customerRibbonFeignClient.getEmployeeGet();
		return response.getBody();

	}
	
	@GetMapping(value = "/getEmpRibbonfeign2")
	public String getEmployeeGet2() {
		ResponseEntity<String> response = customerRibbonFeignClient.getEmployeeGet2();
		return response.getBody();

	}
	
	@GetMapping(value = "/getEmpRibbonfeign3")
	public String getEmpRibbonfeign3() {
		ResponseEntity<String> response = customerRibbonFeignClient.getEmployeeGet3("","");
		return response.getBody();

	}
}
