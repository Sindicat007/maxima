package task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task3.config.AppConfig;
import task3.service.BankPaymentService;

public class StartTask3 {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor paymentProcessor = ctx.getBean(PaymentProcessor.class);
        paymentProcessor.setPaymentService(new BankPaymentService());
        paymentProcessor.handlePayment("ass", 12550);



    }
}
