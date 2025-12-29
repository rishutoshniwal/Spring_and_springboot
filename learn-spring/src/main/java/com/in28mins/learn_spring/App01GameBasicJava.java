package com.in28mins.learn_spring;

public class App01GameBasicJava {

	public static void main(String[] args) {
//		var game = new MarioGame();
//		var game = new SuperContra();
		var game = new Pacman();
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
