package Casting;

public class Service {
    public void process(Shape[] shapes) {
        for (Shape val : shapes) {
            if (val instanceof Circle) {
                val.draw();
                ((Circle) val).calculateArea();
            } else if (val instanceof Rectangle) {
                val.draw();
                ((Rectangle) val).calculateArea();
            } else {
                System.out.println("Что-то пошло не так");
            }
        }
    }
}
