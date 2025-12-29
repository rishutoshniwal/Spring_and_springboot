package com.in28mins.learn_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};

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
		return new Person("Sonam", 28);
		
	}
	
	@Bean(name = "customizedBeanNameForAddress")
	public Address address() {
		return new Address("Nadrai Gate", "Kasganj");
		
	}

}
