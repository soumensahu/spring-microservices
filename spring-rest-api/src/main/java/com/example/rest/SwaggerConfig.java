package com.example.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration
//enable swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Contact DEFAULT_CONTACT = new Contact("Soumen Sahu", "http://soumen.com", "soumen.sahu@accenture.com");
	/*private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"user api", "USer details API", "1.0", "urn:tos", DEFAULT_CONTACT, 
			"Apache 2.0", "http://www.apache.org/license/linces2.0");*/
	private static final ApiInfo DEFAULT_API_INFO=new ApiInfo("user api", "USer details API", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/license/linces2.0",Collections.EMPTY_LIST);
	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUME = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCE_AND_CONSUME)
				.consumes(DEFAULT_PRODUCE_AND_CONSUME);
	}
}
