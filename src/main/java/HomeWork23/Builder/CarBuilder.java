package Homework23.Builder;

public interface CarBuilder {
    void buildEngine();
    void buildBody();
    void buildWheels();
    Car getResult();
}
