package Homework23.FurnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = new FurnitureFactory();

        Furniture chair = factory.createFurniture("chair");
        chair.produce();

        Furniture table = factory.createFurniture("table");
        table.produce();

        Furniture sofa = factory.createFurniture("sofa");
        sofa.produce();
    }
}
