package spring.service;

import org.springframework.stereotype.Component;

@Component
public class PayPalPaymentService implements PaymentService {

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Процесс оплаты со счета PayPal " + account + " сумма: " + amount);
    }
}
