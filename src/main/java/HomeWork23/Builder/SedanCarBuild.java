package Homework23.Builder;

public class SedanCarBuild implements CarBuilder {
    private final Car car = new Car();
    @Override
    public void buildEngine() {
        car.setEngine("Sedan Engine");
    }

    @Override
    public void buildBody() {
        car.setBody("Sedan Body");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Sedan Wheels");
    }

    @Override
    public Car getResult() {
        return car;
    }
}
