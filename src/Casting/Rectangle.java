package Casting;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void calculateArea() {
        double result = this.width * this.height;
        System.out.println(String.format("Площадь квадрата равна %.2f", result));
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

}
