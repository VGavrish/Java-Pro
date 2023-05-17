package HomeWork11;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> list;

    public ThreadSafeList() {
        list = new ArrayList<>();
    }

    public synchronized void add(T item) {
        list.add(item);
    }

    public synchronized void remove(T item) {
        list.remove(item);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }
}
