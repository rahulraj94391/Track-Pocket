package com.org.trackpocket.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Component
@Aspect
public class ControllerLoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("within(com.org.trackpocket.controllers..*)")
    public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
        return printSimpleProceedingJoinPointDetails(pjp);
    }

    private Object printProceedingJoinPointDetails(ProceedingJoinPoint pjp) throws Throwable {
        long initial = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long finish = System.currentTimeMillis();

        // Method Information
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println(signature.getMethod().getName() + " took " + (finish - initial) + "ms to complete.");
        System.out.println("full method description: " + signature.getMethod());
        System.out.println("method name: " + signature.getMethod().getName());
        System.out.println("declaring type: " + signature.getDeclaringType());

        // Method args
        System.out.println("Method args names:");
        Arrays.stream(signature.getParameterNames())
                .forEach(s -> System.out.println("arg name: " + s));

        System.out.println("Method args types:");
        Arrays.stream(signature.getParameterTypes())
                .forEach(s -> System.out.println("arg type: " + s));

        System.out.println("Method args values:");
        Arrays.stream(pjp.getArgs())
                .forEach(o -> System.out.println("arg value: " + o.toString()));

        // Additional Information
        System.out.println("returning type: " + signature.getReturnType());
        System.out.println("method modifier: " + Modifier.toString(signature.getModifiers()));
        Arrays.stream(signature.getExceptionTypes())
                .forEach(aClass -> System.out.println("exception type: " + aClass));


        return proceed;
    }

    private Object printSimpleProceedingJoinPointDetails(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getMethod().getName();
        long initial = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long finish = System.currentTimeMillis();
        logger.info("{} took {}ms to complete.", methodName, finish - initial);
        return proceed;
    }
}
