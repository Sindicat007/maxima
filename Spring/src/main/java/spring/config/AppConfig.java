package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.PaymentProcessor;
import spring.service.BankPaymentService;
import spring.service.PayPalPaymentService;
import spring.service.PaymentService;


@Configuration
public class AppConfig {
    @Bean
    public PaymentService bankPaymentService() {
        return new BankPaymentService();
    }

    @Bean
    public PaymentService payPalPaymentService() {
        return new PayPalPaymentService();
    }

    @Bean
    public PaymentProcessor paymentProcessor() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.setPaymentService(payPalPaymentService());
        return paymentProcessor;
    }
}