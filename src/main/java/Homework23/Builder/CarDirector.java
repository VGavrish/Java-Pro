package Homework23.Builder;

public class CarDirector {
    private final CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void buildCar() {
        carBuilder.buildEngine();
        carBuilder.buildBody();
        carBuilder.buildWheels();
    }

    public Car getCar() {
        return carBuilder.getResult();
    }
}
