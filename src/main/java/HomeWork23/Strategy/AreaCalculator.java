package Homework23.Strategy;

public class AreaCalculator {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double calculatorArea() {
        if (shape == null) {
            throw new IllegalStateException("Shape is not set");
        }
        return shape.getArea();
    }
}
