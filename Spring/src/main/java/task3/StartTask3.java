package task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan("task3")
public class StartTask3 {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(StartTask3.class);

        PaymentProcessor paymentProcessor = ctx.getBean(PaymentProcessor.class);

        paymentProcessor.handlePayment("ass", 12550);

    }
}
