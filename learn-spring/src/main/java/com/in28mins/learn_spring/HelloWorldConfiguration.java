package com.in28mins.learn_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {};

record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Rishu";
	}
	
	@Bean
	public int age() {
		return 26;
		
	}
	
	@Bean
	public Person person() {
		return new Person("Sonam", 28, new Address("Mira Road", "Mumbai"));
		
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
		
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {
		return new Person(name, age, address2);
		
	}
	
	@Bean(name = "customizedBeanNameForAddress")
	public Address address() {
		return new Address("Nadrai Gate", "Kasganj");
		
	}
	
	@Bean(name = "address2")
	public Address address2() {
		return new Address("Sector 62", "Noida");
		
	}

}
