package com.in28Min.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Around("execution(* com.in28Min.learn_spring_aop.aopexample.*.*.*(..))")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// start a timer
		long startTime = System.currentTimeMillis();

		// execute the method
		Object returnValue = proceedingJoinPoint.proceed();

		// stop the timer
		long endTime = System.currentTimeMillis();

		long executionTime = endTime - startTime;

		logger.info("AroundAspect : Method {} executed in duration {} milliseconds", proceedingJoinPoint,
				executionTime);
		return returnValue;
	}

}
