package HomeWork29.coffee.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeOrderBoard {
    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);
    private Queue<Order> orderQueue = new LinkedList<>();
    public void addOrder(Order order) {
        logger.info("Adding order: {}", order.getCustomerName());
        orderQueue.offer(order);
    }
    public Order deliver() {
        Order order = orderQueue.poll();
        if (order != null) {
            logger.info("Delivering order: {}", order.getCustomerName());
        }
        return order;
    }
    public Order deliver(int orderNumber) {
        Order orderToDeliver = null;
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == orderNumber) {
                orderToDeliver = order;
                break;
            }
        }
        if (orderToDeliver != null) {
            orderQueue.remove(orderToDeliver);
            logger.info("Delivering order by number {}: {}", orderNumber, orderToDeliver.getCustomerName());
        }else {
            logger.error("Order not found for delivery: {}", orderNumber);
        }
        return orderToDeliver;
    }

    public void draw() {
        logger.info("Current order queue:");
        logger.info("========== \nNum | Name\n");
        for (Order order : orderQueue) {
            logger.info("{} | {}", order.getOrderNumber(), order.getCustomerName());
        }
    }
}
