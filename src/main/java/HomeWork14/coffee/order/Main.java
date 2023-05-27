package HomeWork14.coffee.order;

public class Main {
    public static void main(String[] args) {
        //for List
//        CoffeeOrderBoardList orderBoard = new CoffeeOrderBoardList();
//        orderBoard.add("Tom");
//        orderBoard.add("Jon");
//        orderBoard.add("Sam");
//        orderBoard.add("July");
//
//        orderBoard.drawOrders();
//
//        Order nextOrder = orderBoard.deliverNextOrder();
//        System.out.println("Delivered order: " + nextOrder.getOrder() + " | " + nextOrder.getName());
//
//        Order specificOrder = orderBoard.deliverOrder(3);
//        System.out.println("Delivered order: " + specificOrder.getOrder() + " | " + specificOrder.getName());
//
//        orderBoard.drawOrders();

        //For Map and Queue
        CoffeeOrderBoardMapQueue coffeeOrderBoard = new CoffeeOrderBoardMapQueue();
        coffeeOrderBoard.add("Tom");
        coffeeOrderBoard.add("Jon");
        coffeeOrderBoard.add("Sam");
        coffeeOrderBoard.add("July");

        coffeeOrderBoard.drawOrder();

        Order order = coffeeOrderBoard.deliverNextOrder();

        System.out.println("Next order: " + order);

        int specificOrderNumber = 2;
        Order deliveryResult = coffeeOrderBoard.deliverOrder(specificOrderNumber);
        if (deliveryResult != null) {
            System.out.println("Order number " + specificOrderNumber + " Delivered successfully.");
        } else  {
            System.out.println("Order number " + specificOrderNumber + " not found in the queue.");
        }

        coffeeOrderBoard.drawOrder();





    }
}
