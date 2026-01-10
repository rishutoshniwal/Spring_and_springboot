package com.in28mins.learn_spring.spring_game_runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28mins.learn_spring.game.GameRunner;
import com.in28mins.learn_spring.game.GamingConsole;

@Configuration
@ComponentScan("com.in28mins.learn_spring.game")
public class App03GameSpring {
	

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		System.out.println("Parameter game "+game);
		return new GameRunner(game);
	}
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(App03GameSpring.class);
		
		var gameRunner=(GameRunner)context.getBean("gameRunner");
		gameRunner.run();
		
		context.getBean(GameRunner.class).run();

	
	}

}
