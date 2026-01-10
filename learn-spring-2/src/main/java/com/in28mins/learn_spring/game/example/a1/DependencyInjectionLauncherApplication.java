package com.in28mins.learn_spring.game.example.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28mins.learn_spring.game.GameRunner;

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	
	}

}
