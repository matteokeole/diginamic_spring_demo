package com.diginamic.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BenchmarkAspect {
	@Around("@within(org.springframework.stereotype.Service)")
	public Object main(final ProceedingJoinPoint joinPoint) {
		final double then = System.currentTimeMillis();
		Object result = null;

		try {
			result = joinPoint.proceed();
		} catch (final Throwable throwable) {
			throw new RuntimeException(throwable);
		}

		final double now = System.currentTimeMillis();
		final double elapsed = now - then;

		System.out.println("Benchmark results for %s#%s: %.2fms".formatted(joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), elapsed));

		return result;
	}
}