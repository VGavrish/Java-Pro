package HomeWork4;

public class Dog extends Animal {
    private String name;
    private static int getCountOfDog;

    public Dog(String name) {
        this.name = name;
        getCountOfDog++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getGetCountOfDog() {
        return getCountOfDog;
    }

    @Override
    public void run(int barrier) {
        if (barrier <= 500) {
            System.out.println(this.name + " �����/�� " + barrier + " �.");
        } else {
            System.out.println("������ �� ���� ���� ���� �� 500 �.");
        }
    }

    @Override
    public void swim(int barrier) {
        if (barrier <= 10) {
        System.out.println(this.name + " �������/�� " + barrier + " �.");
        } else {
        System.out.println("������ �� ���� ����� ���� �� 10 �.");
        }
    }
}
