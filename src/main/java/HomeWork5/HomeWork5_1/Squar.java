package HomeWork5.HomeWork5_1;

public class Squar implements GeometricFigure {
    private final double side;

    public Squar (double side) {
        this.side=side;
    }

    @Override
    public double findOfArea() {
        return side * side;
    }
}
