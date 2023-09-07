package HomeWork29.coffe;

import HomeWork29.coffee.order.CoffeeOrderBoard;
import HomeWork29.coffee.order.Order;
import org.apache.logging.log4j.LogManager;

public class App {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.addOrder(Order.builder().customerName("Volodimer").build());
        orderBoard.addOrder(Order.builder().customerName("Spider").build());
        orderBoard.addOrder(Order.builder().customerName("Sam").build());
        orderBoard.addOrder(Order.builder().customerName("Tom").build());
        orderBoard.addOrder(Order.builder().customerName("Dean").build());
        orderBoard.addOrder(Order.builder().customerName("Anna").build());
        orderBoard.addOrder(Order.builder().customerName("Kate").build());
        orderBoard.addOrder(Order.builder().customerName("Kate").build());

        orderBoard.draw();

        System.out.println("\nGiving order:");

        Order nextOrder = orderBoard.deliver();
        System.out.println("Given: " + nextOrder.getCustomerName());

        nextOrder = orderBoard.deliver(33);
        if (nextOrder != null) {
            System.out.println("Given: " + nextOrder.getOrderNumber());
        }else {
            System.out.println("Order by number 33 not found.");
        }

        System.out.println("\nNew status of queue");
        orderBoard.draw();

        LogManager.shutdown();
    }
}
