package com.in28Min.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("v1/person")
	public PersonV1 getFirstVersionPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("v2/person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(path = "/person", params = "ver=1")
	public PersonV1 getPerson1BasedOnRequestParameter() {
		return new PersonV1("Alice Singh");
	}
	
	@GetMapping(path = "/person", params = "ver=2")
	public PersonV2 getPerson2BasedOnRequestParameter() {
		return new PersonV2(new Name("Bob", "Kumar"));
	}
	
	@GetMapping(path = "/person-header", headers = "X-API-Version=1")
	public PersonV1 getPerson1BasedOnHeader() {
		return new PersonV1("Omika Gupta");
	}
	
	@GetMapping(path = "/person-header", headers = "X-API-Version=2")
	public PersonV2 getPerson2BasedOnHeader() {
		return new PersonV2(new Name("Ishita", "Verma"));
	}


}
