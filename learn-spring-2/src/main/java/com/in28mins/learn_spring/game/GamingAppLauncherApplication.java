package com.in28mins.learn_spring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28mins.learn_spring.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);
		
		var gameRunner=(GameRunner)context.getBean("gameRunner");
		gameRunner.run();
		
		context.getBean(GameRunner.class).run();

	
	}

}
