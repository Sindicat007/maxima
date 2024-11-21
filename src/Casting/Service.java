package Casting;

public class Service {
    public void process(Shape[] shapes) {
        for (Shape val : shapes) {
            if (val instanceof Circle circle) {
                val.draw();
                circle.calculateArea();
            } else if (val instanceof Rectangle rectangle) {
                val.draw();
                rectangle.calculateArea();
            } else {
                System.out.println("Что-то пошло не так");
            }
        }
    }
}
