package com.in28mins.learn_spring;

public class GameRunner {
	GamingConsole game;

	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	
	public void run() {
		System.out.println("Running Game "+ game);
		game.down();
		game.up();
		game.left();
		game.right();
		
	}

}
