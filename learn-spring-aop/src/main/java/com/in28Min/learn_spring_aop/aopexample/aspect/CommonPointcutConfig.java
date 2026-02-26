package com.in28Min.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.in28Min.learn_spring_aop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {
		
	}
	
	@Pointcut("execution(* com.in28Min.learn_spring_aop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {
		
	}
	
	@Pointcut("execution(* com.in28Min.learn_spring_aop.aopexample.data.*.*(..))")
	public void dataPackageConfig() {
		
	}

}
