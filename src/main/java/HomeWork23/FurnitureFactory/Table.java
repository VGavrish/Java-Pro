package Homework23.FurnitureFactory;

public class Table implements Furniture {
    @Override
    public void produce() {
        System.out.println("Creating a table.");
    }
}
