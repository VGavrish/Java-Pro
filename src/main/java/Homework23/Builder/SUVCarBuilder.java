package Homework23.Builder;

public class SUVCarBuilder implements CarBuilder {
    private final Car car = new Car();

    @Override
    public void buildEngine() {
        car.setEngine("SUV Engine");
    }

    @Override
    public void buildBody() {
        car.setBody("SUV Body");
    }

    @Override
    public void buildWheels() {
        car.setWheels("SUV Wheels");
    }

    @Override
    public Car getResult() {
        return car;
    }
}
