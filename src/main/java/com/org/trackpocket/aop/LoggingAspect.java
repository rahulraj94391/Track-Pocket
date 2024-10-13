package com.org.trackpocket.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Around("execution(org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String, java.lang.String>> com.org.trackpocket.controllers.test.PingController.ping())")
    public Object aroundPingAspect(ProceedingJoinPoint pjp) throws Throwable {
        long initial = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long finish = System.currentTimeMillis();
        System.out.println("Ping took " + (finish - initial) + "ms to complete.");
        return proceed;
    }
}
