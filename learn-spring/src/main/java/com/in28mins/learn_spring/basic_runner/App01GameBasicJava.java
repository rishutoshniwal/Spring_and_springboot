package com.in28mins.learn_spring.basic_runner;

import com.in28mins.learn_spring.game.GameRunner;
import com.in28mins.learn_spring.game.Pacman;

public class App01GameBasicJava {

	public static void main(String[] args) {
//		var game = new MarioGame();
//		var game = new SuperContra();
		var game = new Pacman();
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
