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
            System.out.println(this.name + " проб≥г/ла " + barrier + " м.");
        } else {
            System.out.println("—обака не може б≥гти б≥льш н≥ж 500 м.");
        }
    }

    @Override
    public void swim(int barrier) {
        if (barrier <= 10) {
        System.out.println(this.name + " проплив/ла " + barrier + " м.");
        } else {
        System.out.println("—обака не може плити б≥льш н≥ж 10 м.");
        }
    }
}
