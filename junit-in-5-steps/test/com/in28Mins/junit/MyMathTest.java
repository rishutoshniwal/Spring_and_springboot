package com.in28Mins.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	private MyMath myMath = new MyMath();

	@Test
	void testNonEmptyArray() {
		int sum = myMath.calculateSum(new int[]{1,2,3});
		int expectedSum = 6;
		
		assertEquals(expectedSum, sum);

	}
	
	@Test
	void testEmptyArray() {
		int sum = myMath.calculateSum(new int[] {});
		int expectedSum = 0;
		assertEquals(expectedSum, sum);

	}

}
