package Casting;

public class Service {
    public static void process(Shape[] shapes) {
        for (Shape val : shapes) {
            if (val instanceof Circle circle) {
                val.draw();
                circle.calculateArea();
            } else if (val instanceof Rectangle rectangle) {
                val.draw();
                rectangle.calculateArea();
            } else {
                System.out.println("Обработка заданной формы еще не реализована");
            }
        }
    }
}
