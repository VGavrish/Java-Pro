package HomeWork10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator();
        double[] value = new double[1000000];
        calculator.setArray(value);
        Arrays.fill(value, 1.0);
        calculator.calculateValue();
        System.out.println(Arrays.toString(calculator.getArray()));

    }
}
