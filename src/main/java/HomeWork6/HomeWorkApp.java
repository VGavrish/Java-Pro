package HomeWork6;

public class HomeWorkApp {

    public static void main(String[] args) {
    printThreeWorlds();
    checkSumSign();
    printColor();
    compareNumbers();
    range(1,6);
    possitiveOrNegative(-1);
    compareNumbers(-1);
    printValueOfValue(7);
    checkGarbage("21.11.1991");
    checkGarbage("1991");
    }

    //2. Створіть метод printThreeWords(), який під час виклику повинен надрукувати в стовпець у три слова: Orange, Banana, Apple.
    public static void printThreeWorlds() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //3. Створіть метод checkSumSign(), у тілі якого оголосіть дві int змінні a і b, та ініціалізуйте їх будь-якими значеннями, якими захочете.
    // Далі метод повинен підсумувати ці змінні, і якщо їх сума більша або дорівнює 0,
    // то вивести в консоль повідомлення "Сума позитивна", інакше - "Сума негативна";
    public static void checkSumSign() {
        int a = -10;
        int b = 7;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    //4. Створіть метод printColor() у тілі якого задайте int змінну value та ініціалізуйте її будь-яким значенням.
    // Якщо значення менше 0 (0 включно), то в консоль метод повинен вивести повідомлення "Червоний",
    // якщо лежить в межах від 0 (0 виключно) до 100 (100 включно), то "Жовтий", якщо більше 100 (100 виключно) - "Зелений";
    public static void printColor() {
    int value = 101;

        if (value <= 0) System.out.println("Червоний");
        if (value >= 0 && value <= 100) System.out.println("Жовтий");
        if (value >= 100) System.out.println("Зелений");
    }

    //5. Створіть метод compareNumbers(), у тілі якого оголосіть дві int змінні a і b, та ініціалізуйте їх будь-якими значеннями, якими захочете.
    // Якщо a більше або одно b, необхідно вивести в консоль повідомлення “a >= b”, інакше “a < b”;

    public static void compareNumbers() {
        int a = 3;
        int b = 4;
        if (a >= b){
            System.out.println("“a >= b”");
        } else {
            System.out.println("a < b");
        }
    }

    //6. Написати метод, який приймає на вхід два цілих числа і перевіряє, що їхня сума лежить в межах від 10 до 20 (включно),
    // якщо так – повернути true, інакше – false.
    public static boolean range(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    //7. Написати метод, якому як параметр передається ціле число, метод повинен надрукувати в консоль,
    // чи додатнє число передали або від’ємне. Примітка: нуль вважаємо позитивним числом.
    public static void possitiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число доданє");
        } else {
            System.out.println("Число від’ємне");
        }
    }

    //8. Написати метод, якому як параметр передається ціле число. Метод повинен повернути true, якщо число є негативним,
    // і повернути false якщо позитивне.
    public static boolean compareNumbers(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    //9. Написати метод, якому як аргументи передається рядок і число, метод повинен надрукувати в консоль зазначений рядок,
    // вказану кількість разів;
    public static void printValueOfValue(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(count);
        }
    }

    //10. * Написати метод, який визначає, чи є рік високосним, і повертає boolean (високосний – true, не високосний – false).
    // Кожен 4-й рік є високосним, крім кожного 100-го, причому кожен 400-й – високосний.
    public static boolean checkGarbage(String s){
        boolean result = Boolean.parseBoolean(null);

        try {
            int year = Integer.parseInt(s);
            if (year % 100 == 0 && year % 400 == 0) {
                System.out.println("Рік " + s + " має 366 днів. Високосний");
                result = true;
            } else if (year % 4 == 0 && year % 100 > 0) {
                System.out.println("Рік " + s + " має 366 днів. Високосний");
                result = true;
            } else if (year % 100 == 0 ) {
                System.out.println("Рік " + s + " має 365 днів. Не високосний");
                result = false;
            } else {
                System.out.println("Рік " + s + " має 365 днів. Не високосний");
                result = false;
            }
        }catch (NumberFormatException e) {
            System.out.println("Ви вели рік в форматі " + s + " Некоректний формат року, введіть у форматі yyyy");
        }
    return result;
    }
}
