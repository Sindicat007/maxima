package task3;

import org.springframework.stereotype.Component;
import task3.service.PaymentService;

@Component
public class PaymentProcessor {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void handlePayment(String account, double amount) {
        paymentService.processPayment(account, amount);
    }
}
