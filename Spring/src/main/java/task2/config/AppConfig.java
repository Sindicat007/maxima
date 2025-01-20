package task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task2.PaymentProcessor;
import task2.service.BankPaymentService;
import task2.service.PayPalPaymentService;
import task2.service.PaymentService;

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