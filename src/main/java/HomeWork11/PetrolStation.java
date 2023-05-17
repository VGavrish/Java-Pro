package HomeWork11;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private int amount;
    private final Semaphore semaphore;

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
        this.semaphore = new Semaphore(3);
    }

    public void doRefuel(int requestedAmount) {
        try {
            semaphore.acquire();
            System.out.println("Start refueling");
            Thread.sleep((long) (Math.random() * 8000 + 3000));

            synchronized (this) {
                if (requestedAmount < amount) {
                    amount -= requestedAmount;
                    System.out.println("Refueling completed. You got: " + requestedAmount);
                } else {
                    System.out.println("Insufficient fuel available");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
