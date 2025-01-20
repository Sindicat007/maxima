package task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTask1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        PaymentProcessor paymentProcessor = ctx.getBean("paymentProcessor", PaymentProcessor.class);

        paymentProcessor.handlePayment("Alex", 10550);
    }
}
