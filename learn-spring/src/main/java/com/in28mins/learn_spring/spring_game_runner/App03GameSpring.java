package com.in28mins.learn_spring.spring_game_runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28mins.learn_spring.game.GameRunner;

public class App03GameSpring {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(GameSpringConfiguration.class);
		
		var gameRunner=(GameRunner)context.getBean("gameRunner");
		gameRunner.run();
		
		context.getBean(GameRunner.class).run();

	
	}

}
