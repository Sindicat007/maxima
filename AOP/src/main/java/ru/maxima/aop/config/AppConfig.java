package ru.maxima.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.maxima.aop.aspect.LoggingAspect;
import ru.maxima.aop.aspect.TransactionAspect;
import ru.maxima.aop.aspect.ValidationAspect;
import ru.maxima.aop.service.DataService;
import ru.maxima.aop.service.MyService;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public ValidationAspect validationAspect() {
        return new ValidationAspect();
    }
    @Bean
    public DataService dataService() {
        return new DataService();
    }

    @Bean
    public TransactionAspect transactionAspect() {
        return new TransactionAspect();
    }
}
