package Homework23.Strategy;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5,3);

        AreaCalculator calculator = new AreaCalculator();
        calculator.setShape(rectangle);
        double rectangleArea = calculator.calculatorArea();
        System.out.println("Rectangle Area: " + rectangleArea);

        Shape triangle = new Triangle(4,6);
        calculator.setShape(triangle);
        double triangleArea = calculator.calculatorArea();
        System.out.println("Triangle Area: " + triangleArea);

    }
}
