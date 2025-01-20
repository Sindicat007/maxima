package task3.service;

import org.springframework.stereotype.Component;

@Component
public class BankPaymentService implements PaymentService {

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Процесс оплаты с банковского счета " + account + " сумма: " + amount);
    }
}
