package com.in28mins.learn_spring.game.example.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	Dependency dep;

	public SomeClass(Dependency dep) {
		this.dep = dep;
		System.out.println("Dependencies are ready");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Do your initialisation like database initialisation after dependencies are ready");
	}
	
	@PreDestroy
	public void cleanup(){
		System.out.println("Release resources before object destroy");
	}
	
	public void doYourTask() {
		dep.doTask();
	}
	
	
}


@Component
class Dependency {
	
	public void doTask() {
		System.out.println("Perform the business logic");
	}
	
}

@Configuration
@ComponentScan
public class PostConstructAndPreDestroyAnnotationContextLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(PostConstructAndPreDestroyAnnotationContextLauncherApplication.class);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		context.getBean(SomeClass.class).doYourTask();
		
		context.close(); 
	}

}
