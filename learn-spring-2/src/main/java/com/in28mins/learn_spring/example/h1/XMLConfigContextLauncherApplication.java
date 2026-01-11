package com.in28mins.learn_spring.example.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28mins.learn_spring.game.GameRunner;


public class XMLConfigContextLauncherApplication {
	
	public static void main(String[] args) {
		var context = new ClassPathXmlApplicationContext("contextConfiguration.xml");
		
		System.out.println("**********************************************************************************************");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("**********************************************************************************************");
		
		System.out.println();
		System.out.println();
		
		System.out.println(context.getBean("Name"));
		System.out.println(context.getBean("Age"));
		
		System.out.println();
		System.out.println();
		
		context.getBean(GameRunner.class).run();
		
		/*
		 * See the commented part in contextConfiguration.xml file
		 * To see how to do component scan using xml file
		 * and also see how to add beans manually using xml configuration file
		 */
		
		context.close();
	
	}

}
