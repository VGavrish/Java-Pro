package HomeWork5.HomeWork5_1;

public class Triangle implements GeometricFigure {
    private final double base;
    private final double height;

    public Triangle (double base, double height) {
        this.base=base;
        this.height = height;
    }

    @Override
    public double findOfArea() {
        return 0.5 * base * height;
    }
}
