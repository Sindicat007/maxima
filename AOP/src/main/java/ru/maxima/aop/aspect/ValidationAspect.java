package ru.maxima.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    @Before("execution(* com.example.service.DataService.processData(..)) && args(data)")
    public void validateInput(JoinPoint joinPoint, String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Входные данные не могут быть пустыми");
        }
        System.out.println("Данные успешно проверены: " + data);
    }
}
