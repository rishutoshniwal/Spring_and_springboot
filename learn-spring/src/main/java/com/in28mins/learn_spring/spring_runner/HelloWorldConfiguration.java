package com.in28mins.learn_spring.spring_runner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
	@Primary
	public Person person() {
		return new Person("Sonam", 28, new Address("Mira Road", "Mumbai"));
		
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
		
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address customNameForAddress2) {
		return new Person(name, age, customNameForAddress2);
		
	}
	
	@Bean
	public Person person4Qualifier(String name, int age, @Qualifier("address3Qualifier")Address xyz) {
		return new Person(name, age, xyz);
		
	}
	
	@Bean(name = "customizedBeanNameForAddress")
	@Primary
	public Address address() {
		return new Address("Nadrai Gate", "Kasganj");
		
	}
	
	@Bean(name = "customNameForAddress2")
	public Address address2() {
		return new Address("Sector 62", "Noida");
		
	}
	
	@Bean
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address("Gachibowli", "Hyderabad");
		
	}

}
