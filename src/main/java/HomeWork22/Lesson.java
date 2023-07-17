package HomeWork22;

public class Lesson {
    private String name;
    private Homework homework;

    public Lesson(String name, Homework homework) {
        this.name = name;
        this.homework = homework;
    }

    public String getName() {
        return name;
    }

    public Homework getHomework() {
        return homework;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", homework=" + homework +
                '}';
    }
}
