package HomeWork10;

import java.util.Date;

public class ValueCalculator extends Thread {
    private double[] array;

    public double[] getArray() {
        return array;
    }

    public int getArraySize() {
        return array.length;
    }

    public void setArray(double[] values) {
        if (values.length < 1000000) {
            throw new IllegalArgumentException("Array length must be more than 1000000");
        }
        this.array = values;
    }

    public int getHalfArraySize() {
        return array.length/2;
    }


    public void calculateValue() {
        long start = System.currentTimeMillis();

        double[] a1 = new double[getHalfArraySize()];
        double[] a2 = new double[getHalfArraySize()];

        System.arraycopy(array, 0, a1, 0, getHalfArraySize());
        System.arraycopy(array, getHalfArraySize(), a2, 0, getHalfArraySize());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    int index = i;
                    a1[i] = (float)(a1[index] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    int index = i;
                    int offset = getHalfArraySize();
                    a2[i] = (float)(a2[index] * Math.sin(0.2f + (index + offset) / 5) * Math.cos(0.2f + (index + offset) / 5) * Math.cos(0.4f + (index+offset) / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, array, 0, a1.length);
        System.arraycopy(a2, 0, array, a1.length, a2.length);

        long end = System.currentTimeMillis();
        long elapsedTime = start - end;

        System.out.println("Thread time: " + elapsedTime + "ms");

    }
}
