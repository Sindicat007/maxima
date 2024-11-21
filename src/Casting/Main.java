package Casting;

public class Main {
    public static void main(String[] args) {

        Shape[] shapeTest = {new Circle(12), new Rectangle(2, 8), new Circle(3), new Circle(9)};

        Service serv = new Service();
        serv.process(shapeTest);

    }
}
