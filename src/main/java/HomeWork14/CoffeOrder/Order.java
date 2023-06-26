package HomeWork14.CoffeOrder;

public class Order {
    private int order;
    private String name;

    public Order(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order=" + order +
                ", name='" + name + '\'' +
                '}';
    }
}
