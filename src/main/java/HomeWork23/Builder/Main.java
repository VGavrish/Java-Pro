package Homework23.Builder;

public class Main {
    public static void main(String[] args) {
        CarBuilder sedanCarBuilder = new SedanCarBuild();
        CarBuilder suvCarBuilder = new SUVCarBuilder();

        CarDirector sedanCarDirector = new CarDirector(sedanCarBuilder);
        sedanCarDirector.buildCar();
        Car sedanCar = sedanCarDirector.getCar();

        CarDirector suvCarDirector = new CarDirector(suvCarBuilder);
        suvCarDirector.buildCar();
        Car suvCar = suvCarDirector.getCar();

        System.out.println(sedanCar);
        System.out.println(suvCar);

    }
}
