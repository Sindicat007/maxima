package task3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import task3.service.PaymentService;

@Component
public class PaymentProcessor {
    private final PaymentService paymentService;

    public PaymentProcessor(@Qualifier("paypalPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void handlePayment(String account, double amount) {
        paymentService.processPayment(account, amount);
    }
}
