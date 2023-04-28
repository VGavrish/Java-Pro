package HomeWork5_0;

public class Squar implements GeometricFigure {
    private double side;

    public Squar (double side) {
        this.side=side;
    }

    @Override
    public double findOfArea() {
        return side * side;
    }
}
