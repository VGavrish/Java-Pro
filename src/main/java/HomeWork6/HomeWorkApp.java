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

    //2. ������� ����� printThreeWords(), ���� �� ��� ������� ������� ����������� � �������� � ��� �����: Orange, Banana, Apple.
    public static void printThreeWorlds() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //3. ������� ����� checkSumSign(), � �� ����� �������� �� int ���� a � b, �� ����������� �� ����-����� ����������, ����� ��������.
    // ��� ����� ������� ���������� �� ����, � ���� �� ���� ����� ��� ������� 0,
    // �� ������� � ������� ����������� "���� ���������", ������ - "���� ���������";
    public static void checkSumSign() {
        int a = -10;
        int b = 7;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("���� ���������");
        } else {
            System.out.println("���� ���������");
        }
    }

    //4. ������� ����� printColor() � �� ����� ������� int ����� value �� ����������� �� ����-���� ���������.
    // ���� �������� ����� 0 (0 �������), �� � ������� ����� ������� ������� ����������� "��������",
    // ���� ������ � ����� �� 0 (0 ��������) �� 100 (100 �������), �� "������", ���� ����� 100 (100 ��������) - "�������";
    public static void printColor() {
    int value = 101;

        if (value <= 0) System.out.println("��������");
        if (value >= 0 && value <= 100) System.out.println("������");
        if (value >= 100) System.out.println("�������");
    }

    //5. ������� ����� compareNumbers(), � �� ����� �������� �� int ���� a � b, �� ����������� �� ����-����� ����������, ����� ��������.
    // ���� a ����� ��� ���� b, ��������� ������� � ������� ����������� �a >= b�, ������ �a < b�;

    public static void compareNumbers() {
        int a = 3;
        int b = 4;
        if (a >= b){
            System.out.println("�a >= b�");
        } else {
            System.out.println("a < b");
        }
    }

    //6. �������� �����, ���� ������ �� ���� ��� ����� ����� � ��������, �� ���� ���� ������ � ����� �� 10 �� 20 (�������),
    // ���� ��� � ��������� true, ������ � false.
    public static boolean range(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    //7. �������� �����, ����� �� �������� ���������� ���� �����, ����� ������� ����������� � �������,
    // �� ������ ����� �������� ��� �䒺���. �������: ���� ������� ���������� ������.
    public static void possitiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("����� �����");
        } else {
            System.out.println("����� �䒺���");
        }
    }

    //8. �������� �����, ����� �� �������� ���������� ���� �����. ����� ������� ��������� true, ���� ����� � ����������,
    // � ��������� false ���� ���������.
    public static boolean compareNumbers(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    //9. �������� �����, ����� �� ��������� ���������� ����� � �����, ����� ������� ����������� � ������� ���������� �����,
    // ������� ������� ����;
    public static void printValueOfValue(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(count);
        }
    }

    //10. * �������� �����, ���� �������, �� � �� ����������, � ������� boolean (���������� � true, �� ���������� � false).
    // ����� 4-� �� � ����������, ��� ������� 100-��, ������� ����� 400-� � ����������.
    public static boolean checkGarbage(String s){
        boolean result = Boolean.parseBoolean(null);

        try {
            int year = Integer.parseInt(s);
            if (year % 100 == 0 && year % 400 == 0) {
                System.out.println("г� " + s + " �� 366 ���. ����������");
                result = true;
            } else if (year % 4 == 0 && year % 100 > 0) {
                System.out.println("г� " + s + " �� 366 ���. ����������");
                result = true;
            } else if (year % 100 == 0 ) {
                System.out.println("г� " + s + " �� 365 ���. �� ����������");
                result = false;
            } else {
                System.out.println("г� " + s + " �� 365 ���. �� ����������");
                result = false;
            }
        }catch (NumberFormatException e) {
            System.out.println("�� ���� �� � ������ " + s + " ����������� ������ ����, ������ � ������ yyyy");
        }
    return result;
    }
}
