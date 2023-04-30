package HomeWork7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    findSymbolOccurance("DobruyDenoEveRyBody", 'o');
    findWordPosition("Apollo", "k");
    stringReverse("revers");
    isPalindrome("Agro");
    game();
    }

    //2. �������� ����� findSymbolOccurance. ����� ������ �� �������� ����� � ������. ��������� ���������,
    // ������ ���� ������ ����������� � ���������� ����� � ��������� �� ������� ��������.
    public static int findSymbolOccurance(String world, char symbol) {
    char a[] = world.toCharArray();
    int countOfSymbols = 0;
        for (int i = 0; i < a.length; i++) {
            char checkChar = a[i];
            if (checkChar == symbol) {
                countOfSymbols++;
            }
        }
        return countOfSymbols;
    }

    //3. �������� ����� findWordPosition. ����� ������ �� ��������� ��� ����� (source, target). ��������� �'�������,
    // �� � target (�������) �������� ����� source. ���� ���,
    // ��� ��������� ����� ������� (������) ������� �������� ������� � �����, ������ ��������� -1.
    public static int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        return index;
    }

    //4. �������� ����� stringReverse. ����� ������ �� �������� - �����. ��������� �� ���������� �� ��������� ������� ������.
    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //5. �������� ����� isPalindrome. ����� ������ �� �������� - �����. ��������� ���������, �� � ��������� ����� ����������.
    // ���� ���, ��� ��������� true, ������ false.
    public static boolean isPalindrome(String str) {
        String reserved = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reserved);
    }

    //6. ��� ������� �������� ����'���� ������ �����, ������ ������� � �����������,
    //������� ���� �� ��������� ������ �� ��������� �� ��������� ������ ����������.
    // ���� ����� �� �������, ����'���� ������ �����, �� ������ �� ���� �����.
    public static void game() {
        String massive[] = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        Random random = new Random();
        String secretWord = massive[random.nextInt(massive.length)];

        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;

        System.out.println("����'���� ������� �����. ��������� ��������:");

        while (!isGuessed) {
            System.out.println("������ ���� �����:");
            String userWorld = scanner.next();

            if (userWorld.equals(secretWord)) {
                isGuessed = true;
            } else {
                StringBuilder hint = new StringBuilder("###############");
                int minLenght = Math.min(userWorld.length(), secretWord.length());

                for (int i = 0; i < minLenght; i++) {
                    if (userWorld.charAt(i) == secretWord.charAt(i)) {
                        hint.setCharAt(i, userWorld.charAt(i));
                    }
                }
                System.out.println("�� ����! ϳ�������: " + hint);
            }
        }
        System.out.println("³���! �� �������� �����: " + secretWord);
        scanner.close();
    }
}
