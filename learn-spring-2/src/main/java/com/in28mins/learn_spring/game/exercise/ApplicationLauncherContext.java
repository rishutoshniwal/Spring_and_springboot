package com.in28mins.learn_spring.game.exercise;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



interface DataService {
	public int[] retrieveData();
}

@Component
@Primary
class MongoDataService implements DataService {
	
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
	
}

@Component
class MySqlDataService implements DataService {
	
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
	
}

@Component
class BusinessCalculationService {
	
	DataService dataService;
	
	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}

	public int findMax() {
		int[] data = dataService.retrieveData();
		
		int max=0;
		for(int x: data)
			max=Math.max(max, x);
		
		return max;
		
	}

}

@Configuration
@ComponentScan
public class ApplicationLauncherContext{
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ApplicationLauncherContext.class);
		
		System.out.println("*********************************************************************************");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("*********************************************************************************");
		System.out.println("This is done just to print all bean names \n\n\n\n\n\n");
		
		
		System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		
		
	
	}
	
}
