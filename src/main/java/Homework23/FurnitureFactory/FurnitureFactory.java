package Homework23.FurnitureFactory;

public class FurnitureFactory {
    public Furniture createFurniture(String type) {
        if("chair".equalsIgnoreCase(type)) {
            return new Chair();
        } else if ("table".equalsIgnoreCase(type)) {
            return new Table();
        } else if ("sofa".equalsIgnoreCase(type)) {
            return new Sofa();
        }else {
            throw new IllegalArgumentException("Invalid furniture type." + type);
        }
    }
}
