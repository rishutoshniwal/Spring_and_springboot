package com.in28mins.learn_spring.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraQualifier")
public class SuperContra implements GamingConsole{
	public void up() {
		System.out.println("Go up SuperContra" );
		
	}
	
	public void down() {
		System.out.println("Go down SuperContra" );
		
	}
	
	public void left() {
		System.out.println("Go left SuperContra" );
		
	}
	
	public void right() {
		System.out.println("Go right SuperContra" );
		
	}
}