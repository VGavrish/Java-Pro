package HomeWork5_1;

public class Wall implements Obstacle {
    private int Height;
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return Height;
    }

    public Wall(String name, int height) {
        this.name = name;
        this.Height = height;
    }

    @Override
    public boolean overCome(Participant participant) {
        if (participant.getMaxJumpHeight() >= Height) {
            participant.jump();
            return true;
        }
        return false;
    }

    public void setHeight(int height) {
        Height = height;
    }
}
