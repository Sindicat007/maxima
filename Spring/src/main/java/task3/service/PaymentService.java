package task3.service;

import org.springframework.stereotype.Component;

@Component
public interface PaymentService {
    void processPayment(String account, double amount);
}
