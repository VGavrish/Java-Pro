package HomeWork4;

public class Cat extends Animal {
    private String name;
    private static int countOfCat;

    public Cat(String name) {
        this.name = name;
        countOfCat++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCatCount () {
        return countOfCat;
    }

    @Override
    public void run(int barrier) {
        if (barrier <= 200) {
            System.out.println(this.name + " пробіг/ла " + barrier + " м.");
        } else {
            System.out.println("Кіт не може бігти більш ніж 200 м.");
        }
    }

    @Override
    public void swim(int barrier) {
        System.out.println("Кіт не вміє плавати");
    }
}
