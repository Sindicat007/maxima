package ru.maxima.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeOutAspect {

    private static long lastExecutionTime = 0;

    @Around("execution(* ru.maxima.aop.service.MyService.doWithTimeOut(..))")
    public void timeoutExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        if (lastExecutionTime == 0) {
            lastExecutionTime = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - lastExecutionTime < 5000) {
            System.out.println("Повторно выполнить метод можно будет через " +
                    (5000 - (System.currentTimeMillis() - lastExecutionTime)) +
                    " миллисекунд\n");
            return;
        }
        joinPoint.proceed();
        System.out.println();
        lastExecutionTime = System.currentTimeMillis();
    }
}
