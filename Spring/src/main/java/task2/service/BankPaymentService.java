package task2.service;

public class BankPaymentService implements PaymentService {

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Процесс оплаты с банковского счета " + account + " сумма: " + amount);
    }
}
