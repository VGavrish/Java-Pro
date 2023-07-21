package Homework23.Strategy;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }
    @Override
    public double getArea() {
        return width * height;
    }
}
