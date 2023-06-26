package HomeWork5.HomeWork5_1;

public class Circle implements GeometricFigure {
    private final double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    @Override
    public double findOfArea() {
        return Math.PI * radius * radius;
    }
}
