package Casting;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void calculateArea() {
        double result = Math.PI * (this.radius * this.radius);
        System.out.println(String.format("Площадь круга равна %.2f", result));
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
