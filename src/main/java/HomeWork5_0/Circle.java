package HomeWork5_0;

public class Circle implements GeometricFigure {
    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    @Override
    public double findOfArea() {
        return Math.PI * radius * radius;
    }
}
