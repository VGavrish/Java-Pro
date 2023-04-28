package HomeWork5_0;

public class Main {
    public static void main(String[] args) {
        GeometricFigure[] figures = {
                new Circle(5),
                new Triangle(10, 6),
                new Squar(4)
        };

        System.out.println("Сумарна площа всіх фігур: " + calculateTotalArea(figures));

    }

    public static double calculateTotalArea (GeometricFigure[] figures) {
        double totalArea = 0;

        for (GeometricFigure figure : figures) {
            totalArea += figure.findOfArea();
        }
        return totalArea;
    }
}
