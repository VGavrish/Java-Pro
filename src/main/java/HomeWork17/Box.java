package HomeWork17;

import java.util.ArrayList;
import java.util.List;

    class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruits(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruitsToAdd) {
        fruits.addAll(fruitsToAdd);
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                totalWeight += Apple.WEIGHT;
            } else if (fruit instanceof Orange) {
                totalWeight += Orange.WEIGHT;
            }
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void merge(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }
        if (fruits.isEmpty() || otherBox.fruits.isEmpty()
            || fruits.get(0).getClass() == otherBox.fruits.get(0).getClass()) {
            fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            throw new IllegalArgumentException("Can't merge boxes because they have different types");
        }
    }
}
