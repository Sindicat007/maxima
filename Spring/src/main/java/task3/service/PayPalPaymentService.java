package task3.service;

import org.springframework.stereotype.Component;

@Component("paypalPaymentService")
public class PayPalPaymentService implements PaymentService {

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Процесс оплаты со счета PayPal " + account + " сумма: " + amount);
    }
}
