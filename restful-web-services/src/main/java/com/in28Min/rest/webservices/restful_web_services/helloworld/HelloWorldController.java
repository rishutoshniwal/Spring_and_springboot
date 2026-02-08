package com.in28Min.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World1";
	}

}
