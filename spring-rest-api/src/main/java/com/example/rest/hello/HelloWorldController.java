package com.example.rest.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET,path="/hello")
	public String helloWorld() {
		return "Hello world";
	}
	@GetMapping(path="/hellobean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path="/hello/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("hello : %s",name ));
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-in18")
	public String helloWorldIN18() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
