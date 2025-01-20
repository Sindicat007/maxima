import spring.PaymentProcessor;
import spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor paymentProcessor = context.getBean(PaymentProcessor.class);
        paymentProcessor.handlePayment("ass", 12550);

    }
}
