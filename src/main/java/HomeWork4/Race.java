package HomeWork4;

public class Race {

    public static void main(String[] args) {

        Cat Molly = new Cat("Molly");
        Molly.run(199);
        Molly.swim(10);
        Cat Abi = new Cat("Abi");
        Abi.run(200);
        Abi.swim(1);
        System.out.println("—к≥льки кот≥в: " + Cat.getCatCount());
        System.out.println("___________");

        Dog Bob = new Dog("Bob");
        Bob.run(500);
        Bob.swim(11);
        System.out.println("—к≥льки собак: " + Dog.getGetCountOfDog());

    }
}
