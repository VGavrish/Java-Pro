package HomeWork11;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(1000);
        petrolStation.doRefuel(80);
        petrolStation.doRefuel(82);
        petrolStation.doRefuel(152);
        petrolStation.doRefuel(500);
        petrolStation.doRefuel(500);


        ThreadSafeList<String> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add("Box 1");
        threadSafeList.add("Box 2");
        threadSafeList.add("Box 3");

        threadSafeList.remove("Box 2");

        String box = threadSafeList.get(0);
        System.out.println(box);
    }
}
