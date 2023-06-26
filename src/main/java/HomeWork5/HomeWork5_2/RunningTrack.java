package HomeWork5.HomeWork5_2;

public class RunningTrack implements Obstacle{
    private String name;
    private int distance;

    public RunningTrack(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public boolean overCome(Participant participant) {
        if (participant.getMaxRunDistance() >= distance) {
            participant.run();
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
