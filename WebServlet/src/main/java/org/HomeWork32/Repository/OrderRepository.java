package org.HomeWork32.Repository;

import org.HomeWork32.DTO.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();
    private Long nextId = 1L;

    public Order getById(Long id) {
        return orders.get(id);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public void add(Order order) {
        order.setId(nextId);
        orders.put(nextId, order);
        nextId++;
    }
}

