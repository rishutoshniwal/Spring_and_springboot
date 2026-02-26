package com.in28Min.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


// Configuration
// AOP
@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Pointcut - when?@
	@Before("execution(* com.in28Min.learn_spring_aop.aopexample.*.*.*(..))")
	public void logMethodCallBefore(JoinPoint joinPoint) {
		// Logic - what?
		logger.info("Before Aspect :: Method is called {}", joinPoint);
		
	}

}
