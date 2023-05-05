package HomeWork8;

public class Main {
    static String mass[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "sds"}};

    public static void main(String[] args) {
        try {
            ArrayValueCalculator calculator = new ArrayValueCalculator();
            System.out.println(calculator.doCalc(mass));
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println("Помилка: " + e.getMessage());
            }
    }
}
