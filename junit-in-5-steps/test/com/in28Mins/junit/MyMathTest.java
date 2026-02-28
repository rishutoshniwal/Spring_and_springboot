package com.in28Mins.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	void test() {
		int[] arr= {1,2,3};
		MyMath myMath = new MyMath();
		int sum = myMath.calculateSum(arr);
		int expectedSum = 6;
		
		assertEquals(expectedSum, sum);

	}

}
