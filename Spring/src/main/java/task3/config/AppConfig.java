package task3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import task3.PaymentProcessor;
import task3.service.BankPaymentService;
import task3.service.PayPalPaymentService;


@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public PaymentProcessor paymentProcessor() {
        return new PaymentProcessor();
    }
}