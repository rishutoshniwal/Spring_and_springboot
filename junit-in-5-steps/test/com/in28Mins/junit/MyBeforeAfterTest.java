package com.in28Mins.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("@BeforeEach runs before every test, Do any SETUP that you want to do before test");
	}
	
	@AfterEach
	public void afterEachTest() {
		System.out.println("@AfterEach runs after every test, Do any CLEANUP that you want to do after test");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll runs once before running any test case, Do any SETUP that you want to do for all the tests");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll runs after all test cases, Do any CLEANUP that you want to do after running all the tests");
	}

	@Test
	void test1() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@Test
	void test3() {
		System.out.println("test3");
	}

}
