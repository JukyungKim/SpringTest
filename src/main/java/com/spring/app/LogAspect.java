package com.spring.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Around("@annotation(LogExecutionTime)")
	public Object LogExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Annotation test");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceed = joinPoint.proceed();
		
		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());
		
		return proceed;
	}
}
