package org.HomeWork32.Controller;

import org.HomeWork32.DTO.Order;
import org.HomeWork32.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getProductById(@PathVariable Long id) {
        return orderRepository.getById(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderRepository.add(order);
    }
}
