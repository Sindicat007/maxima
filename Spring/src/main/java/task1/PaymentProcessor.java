package task1;

import task1.service.PaymentService;

public class PaymentProcessor {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void handlePayment(String account, double amount) {
        paymentService.processPayment(account, amount);
    }
}
