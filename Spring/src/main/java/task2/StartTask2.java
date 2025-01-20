package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task2.config.AppConfig;

public class StartTask2 {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentProcessor paymentProcessor = ctx.getBean(PaymentProcessor.class);

        paymentProcessor.handlePayment("Viktor", 12550);


    }
}
