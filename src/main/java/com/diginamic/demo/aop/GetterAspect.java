package com.diginamic.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GetterAspect {
	@After("execution(* com.diginamic.demo.controller..get*(..))")
	public void main(final JoinPoint joinPoint) {
		System.out.println("Controller /^get/ method called: \"%s\"".formatted(joinPoint.getSignature().getName()));
	}
}