package HomeWork14.coffee.order;

import java.util.*;

public class CoffeeOrderBoardList {
    private final List<Order> orders;
    int nextOrderNumber;

    public CoffeeOrderBoardList() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(nextOrderNumber, name);
        orders.add(order);
        nextOrderNumber++;
    }

    public Order deliverNextOrder() {
        if (!orders.isEmpty()) {
            Order nextOrder =  orders.get(0);
            orders.remove(0);
            return nextOrder;
        }
        return null;
    }

    public Order deliverOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrder() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void drawOrders() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrder() + " | " + order.getName());
        }
    }
}
