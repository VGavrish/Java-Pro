package HomeWork15;

public class Main {
    public static void main(String[] args) {
        int[] array = {9,1,5,7};
        //QuickSort.quickSort(array);
        ShakerSort.shakerSort(array);
        for (int num : array) {
            System.out.println(num + " ");
        }
    }

}
