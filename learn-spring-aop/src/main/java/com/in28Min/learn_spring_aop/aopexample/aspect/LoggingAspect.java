package com.in28Min.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	// Pointcut - when?
	@Before("com.in28Min.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallBefore(JoinPoint joinPoint) {
		// Logic - what?
		logger.info("Before Aspect :: Method is called - {}", joinPoint);

	}

	@After("com.in28Min.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		// Logic - what?
		logger.info("After Aspect :: Method has executed - {}", joinPoint);

	}

	@AfterThrowing(pointcut = "com.in28Min.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()", throwing = "exception")
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
	}

	@AfterReturning(pointcut = "com.in28Min.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()", returning = "resultValue")
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
	}

}
