package HomeWork5_0;

public class Triangle implements GeometricFigure {
    private double base;
    private double height;

    public Triangle (double base, double height) {
        this.base=base;
        this.height = height;
    }

    @Override
    public double findOfArea() {
        return 0.5 * base * height;
    }
}
