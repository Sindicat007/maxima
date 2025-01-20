import org.springframework.context.support.ClassPathXmlApplicationContext;
import task1.service.BankPaymentService;
import task1.service.PaymentService;
import task1.PaymentProcessor;
import task2.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
////        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        PaymentProcessor paymentProcessor = ctx.getBean("paymentService", PaymentProcessor.class);
//
//        PaymentService bankPaymentService = new BankPaymentService();
//        paymentProcessor.setPaymentService(bankPaymentService);
//        paymentProcessor.handlePayment("ass", 12550);


//        PaymentProcessor paymentProcessor = context.getBean(PaymentProcessor.class);
//        paymentProcessor.handlePayment("ass", 12550);

    }
}
