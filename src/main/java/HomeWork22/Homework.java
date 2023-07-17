package HomeWork22;

public class Homework {
    private final String name;
    private final String description;

    public Homework(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
