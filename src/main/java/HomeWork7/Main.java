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

    //2. Створити метод findSymbolOccurance. Метод приймає як параметр рядок і символ. Необхідно обчислити,
    // скільки разів символ зустрічається в переданому рядку і повернути це числове значення.
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

    //3. Створити метод findWordPosition. Метод приймає як параметри два рядки (source, target). Необхідно з'ясувати,
    // чи є target (підрядок) частиною рядка source. Якщо так,
    // тоді повернути номер позиції (індекс) першого елемента підрядка у рядку, інакше повернути -1.
    public static int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        return index;
    }

    //4. Створити метод stringReverse. Метод приймає як параметр - рядок. Необхідно її розгорнути та повернути змінений варіант.
    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //5. Створити метод isPalindrome. Метод приймає як параметр - рядок. Необхідно Перевірити, чи є переданий рядок паліндромом.
    // Якщо так, тоді повернуть true, інакше false.
    public static boolean isPalindrome(String str) {
        String reserved = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reserved);
    }

    //6. При запуску програми комп'ютер загадує слово, запитує відповідь у користувача,
    //порівнює його із загаданим словом та повідомляє чи правильно відповів користувач.
    // Якщо слово не вгадано, комп'ютер показує літери, які стоять на своїх місцях.
    public static void game() {
        String massive[] = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        Random random = new Random();
        String secretWord = massive[random.nextInt(massive.length)];

        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;

        System.out.println("Комп'ютер загадав слово. Спробуйте відгадати:");

        while (!isGuessed) {
            System.out.println("Введіть ваше слово:");
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
                System.out.println("Не вірно! Підсказка: " + hint);
            }
        }
        System.out.println("Вітаю! Ви відгадали слово: " + secretWord);
        scanner.close();
    }
}
