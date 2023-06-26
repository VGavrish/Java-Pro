package HomeWork5.HomeWork5_2;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Vitos", 100, 3),
                new Cat("Oleg", 150, 4),
                new Robot("Vitya", 200, 5)
        };

        Obstacle[] obstacles = {
                new RunningTrack("Speed1000", 90),
                new Wall("Стіна",2)
        };

        for (Participant participant : participants) {
            boolean isPatricipantActiva = true;
            for (Obstacle obstacle : obstacles) {
                if (isPatricipantActiva) {
                    isPatricipantActiva = obstacle.overCome(participant);
                    if (isPatricipantActiva) {
                        System.out.println("Учасник[" + participant.getName() +
                                "] пройшов перешкоду [" + obstacle.getName() +
                                "] на дистанції [" + obstacle.getValue() + "].");
                    } else {
                        System.out.println("Учасник[" + participant.getName() +
                                "] не пройшов перешкоду[" + obstacle.getName() +
                                "] на дистанції[" + obstacle.getValue() + "].");
                    }
                }
            }
        }
    }
}
