package com.diginamic.demo.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
	@AfterThrowing(pointcut="@within(org.springframework.stereotype.Service)", throwing="exception")
	public void main(final Exception exception) {
		System.out.println("Caught exception: %s".formatted(exception));
	}
}