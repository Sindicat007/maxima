package ru.maxima.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeOutAspect {

    private static long time;

    @Around("execution(* ru.maxima.aop.service.MyService.doWithTimeOut(..))")
    public Object timeoutExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        if (time == 0) {
            time = System.currentTimeMillis();
        } else if (time - startTime < 5000) {
            System.out.println("Процесс продолжится через  " + (5000 - (time - startTime)) + "\n");
            Thread.sleep(5000 - (time - startTime));
        }
        joinPoint.proceed();
        System.out.println();
        time = System.currentTimeMillis();
        return "";
    }
}
