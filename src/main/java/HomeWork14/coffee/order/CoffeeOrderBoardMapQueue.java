package HomeWork14.coffee.order;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CoffeeOrderBoardMapQueue {
    private final Map<Integer, Order> orderMap;
    private final Queue<Integer> orderQueue;
    private int nextOrderNumber;

    public CoffeeOrderBoardMapQueue() {
        orderMap = new HashMap<>();
        orderQueue = new LinkedList<>();
        nextOrderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(nextOrderNumber, name);
        orderMap.put(nextOrderNumber, order);
        orderQueue.add(nextOrderNumber);
        nextOrderNumber++;
    }

    public Order deliverNextOrder() {
        Integer orderNumber = orderQueue.poll();
        if (orderNumber != null) {
            Order order = orderMap.get(orderNumber);
            orderMap.remove(orderNumber);
            return order;
        }
        return null;
    }

    public Order deliverOrder(int orderNumber) {
        Order order = orderMap.get(orderNumber);
        if (order != null) {
            orderMap.remove(orderNumber);
            orderQueue.remove(orderNumber);
            return order;
        }
        return null;
    }

    public void drawOrder() {
        System.out.println("Num | Name");
        for (int orderNumber : orderQueue) {
            Order order = orderMap.get(orderNumber);
            System.out.println(order.getOrder() + " | " + order.getName());
        }
    }
}
