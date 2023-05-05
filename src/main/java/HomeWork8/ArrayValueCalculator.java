package HomeWork8;

public class ArrayValueCalculator {
    public int doCalc(String[][] array) throws ArrayDataException, ArraySizeException {
        int sum = 0;
            if (array.length != 4 || array[0].length != 4) {
                throw new ArraySizeException("Розмір масива має бути 4х4");
            } else {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        try {
                            int number = Integer.parseInt(array[i][j]);
                            sum += number;
                        } catch (NumberFormatException e) {
                            throw new ArrayDataException("Помилка у ячійці[" + i + "][" + j + "]:" + e.getMessage());
                        }
                    }
                }
            }
            return sum;
        }
}
