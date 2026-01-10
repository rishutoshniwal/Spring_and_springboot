package com.in28mins.learn_spring.game.example.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	
	Dependency1 dep1;
	Dependency2 dep2;
	
//	@Autowired
	public YourBusinessClass(Dependency1 dep1, Dependency2 dep2) {
		System.out.println("Constructor Injection dep1");
		this.dep1 = dep1;
		this.dep2 = dep2;
	}

	
//	@Autowired
//	public void setDep1(Dependency1 dep1) {
//		System.out.println("Setter Injection dep1");
//		this.dep1 = dep1;
//	}
//
//	@Autowired
//	public void setDep2(Dependency2 dep2) {
//		System.out.println("Setter Injection dep2");
//		this.dep2 = dep2;
//	}
	
	public String toString() {
		return "Field Injection: Dependency1 --> " + dep1 +" \n Dependency2 --> " + dep2;
	}

	
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class);
		
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		System.out.println(context.getBean(YourBusinessClass.class));
	
	}

}
