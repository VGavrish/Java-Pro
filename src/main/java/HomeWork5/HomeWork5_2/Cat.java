package HomeWork5.HomeWork5_2;

public class Cat implements Participant {
    private final String name;
    private final int maxRunDistance;
    private final int maxJumpHeight;

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void run() {
        System.out.println(this.name + " біжить");
    }

    @Override
    public void jump() {
        System.out.println(this.name + " стрибає");

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    @Override
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}
