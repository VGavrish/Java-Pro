package HomeWork4;

public class Animal {

    public void run(int barrier) {
        System.out.println(getClass().getName() + " пробіг " + barrier);
    }

    public void swim(int barrier) {
        System.out.println(getClass().getName() + " проплив/ла " + barrier);
    }

}
