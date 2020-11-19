package com.snkit.springproxy;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CustomFeignInterceptor implements RequestInterceptor {

	public static Logger logger = LoggerFactory.getLogger(CustomFeignInterceptor.class);

	@Override
	public void apply(RequestTemplate template) {
		
	
		template.header("token", UUID.randomUUID().toString() );
		logger.info("  From Custom Feign Interceptor");
	}

}
