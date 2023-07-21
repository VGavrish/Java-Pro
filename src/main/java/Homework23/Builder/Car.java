package Homework23.Builder;

public class Car {
    private String engine;
    private String body;
    private String wheels;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", wheels='" + wheels + '\'' +
                '}';
    }
}
