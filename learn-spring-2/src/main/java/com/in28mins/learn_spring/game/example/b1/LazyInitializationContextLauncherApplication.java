package com.in28mins.learn_spring.game.example.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	
	ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Initialisation logic goes here");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
	
}

@Configuration
@ComponentScan
public class LazyInitializationContextLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(LazyInitializationContextLauncherApplication.class);
		
		System.out.println("Initialization of context is completed");
		
		context.getBean(ClassB.class).doSomething();
		
		// To Learn : Comment and Uncomment the @Lazy decorator and see the difference in output
		// With @Lazy: Initialization of bean does not happen until the bean is used
	
	}

}
