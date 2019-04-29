package com.example.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//using simple uri
	@GetMapping("/v1/person")
	public PersonV2 personv2() {
		return new PersonV2("Bob Charlie");
	}
	@GetMapping("/v2/person")
	public PersonV1 personv1() {
		return new PersonV1(new Name("Bob","Charlie"));
	}
	
	//using param
	@GetMapping(value="/person/param",params="version=1")
	public PersonV2 paramv2() {
		return new PersonV2("Bob Charlie");
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV1 paramv1() {
		return new PersonV1(new Name("Bob","Charlie"));
	}
	
	//using headers
	@GetMapping(value="/person/headers",headers="X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2("Bob Charlie");
	}
	@GetMapping(value="/person/headers",headers="X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1(new Name("Bob","Charlie"));
	}
	
	//using produces
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producev2() {
		return new PersonV2("Bob Charlie");
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producev1() {
		return new PersonV1(new Name("Bob","Charlie"));
	}
	
}
