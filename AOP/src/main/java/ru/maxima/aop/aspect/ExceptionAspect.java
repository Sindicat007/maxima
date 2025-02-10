package ru.maxima.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    @Before("execution(* ru.maxima.aop.service.DataService.processData(..)) && args(data)")
    public void handleException(JoinPoint joinPoint, String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println(joinPoint.getSignature().getName());
            throw new IllegalArgumentException("Входные данные не могут быть пустыми");
        }
    }

    @Around("execution(* ru.maxima.aop.service.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Ошибка, мать ее: " + e.getMessage());
        }
        return joinPoint.toString();
    }
}
