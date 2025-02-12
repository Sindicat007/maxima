package ru.maxima.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void doSomething())")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Вызван метод: " + joinPoint.getSignature().getName());
    }

    @Around("execution(public void doSomething())")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed(); // Выполнение метода
        long endTime = System.currentTimeMillis();
        System.out.println("Метод " + proceedingJoinPoint.getSignature().getName() +
                " выполнен за " + (endTime - startTime) + " мс");
        return result;
    }


}
