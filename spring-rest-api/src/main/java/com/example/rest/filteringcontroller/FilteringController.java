package com.example.rest.filteringcontroller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue getEmp() {
		Employee emp=new Employee(1001,"soumen");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id");
		FilterProvider filters=new SimpleFilterProvider().addFilter("nameFilter", filter);
		MappingJacksonValue mapping= new MappingJacksonValue(emp);
		mapping.setFilters(filters);
		
		
		return mapping;
	}
}
