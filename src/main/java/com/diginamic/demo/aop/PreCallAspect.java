package com.diginamic.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PreCallAspect {
	@Before("within(com.diginamic.demo.controller.*)")
	public void main(final JoinPoint joinPoint) {
		System.out.println("Calling %s#%s".formatted(joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName()));
	}
}