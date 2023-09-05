package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final static List<Order> orders = new ArrayList<>();

    public static Order getOrder (int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> getAllOrders() {
        return orders;
    }
}
