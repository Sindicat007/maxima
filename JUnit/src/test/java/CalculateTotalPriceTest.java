import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.maxima.maven.example.Order;
import ru.maxima.maven.example.Product;

@DisplayName("Тестирование подсчета общей цены")
class CalculateTotalPriceTest {

    @Test
    @DisplayName("Проверка подсчета цены за один продукт")
    void calculateTotalPrice1() {
        Product apple = new Product(1, "Apple", 100.0);

        Order order1 = new Order();
        order1.addProduct(apple);

        order1.calculateTotalPrice();
        Assertions.assertEquals(100.0, order1.calculateTotalPrice());
    }

    @Test
    @DisplayName("Проверка подсчета нескольких цен")
    void calculateTotalPrice() {
        Product apple = new Product(1, "Apple", 100.0);
        Product orange = new Product(2, "Orange", 150.0);

        Order order1 = new Order();
        order1.addProduct(apple);
        order1.addProduct(orange);

        order1.calculateTotalPrice();
        Assertions.assertEquals(250.0, order1.calculateTotalPrice());

    }

    @Test
    @DisplayName("Проверка пустого заказа")
    void calculateNullOrder() {
        Order order1 = new Order();
        order1.calculateTotalPrice();

        Assertions.assertEquals(0.0, order1.calculateTotalPrice());
    }
}
