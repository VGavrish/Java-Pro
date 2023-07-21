package Homework23.FurnitureFactory;

public class Chair implements Furniture {
    @Override
    public void produce() {
        System.out.println("Creating a chair.");
    }
}
