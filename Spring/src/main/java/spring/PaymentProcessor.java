package spring;

import org.springframework.stereotype.Component;
import spring.service.PaymentService;


@Component
public class PaymentProcessor {
    PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void handlePayment(String account, double amount) {
        paymentService.processPayment(account, amount);
    }
}
