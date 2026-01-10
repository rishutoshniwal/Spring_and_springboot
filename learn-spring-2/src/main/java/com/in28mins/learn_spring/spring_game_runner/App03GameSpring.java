package com.in28mins.learn_spring.spring_game_runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28mins.learn_spring.game.GameRunner;

@Configuration
@ComponentScan("com.in28mins.learn_spring.game")
public class App03GameSpring {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(App03GameSpring.class);
		
		var gameRunner=(GameRunner)context.getBean("gameRunner");
		gameRunner.run();
		
		context.getBean(GameRunner.class).run();

	
	}

}
