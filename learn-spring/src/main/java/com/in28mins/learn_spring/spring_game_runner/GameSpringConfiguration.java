package com.in28mins.learn_spring.spring_game_runner;

import org.springframework.context.annotation.Bean;

import com.in28mins.learn_spring.game.GameRunner;
import com.in28mins.learn_spring.game.GamingConsole;
import com.in28mins.learn_spring.game.Pacman;

public class GameSpringConfiguration {
	 
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
	
	@Bean
	public GamingConsole gamingConsole() {
		return new Pacman();
	}
	 

}
