package HomeWork18;

import java.time.LocalDate;
import java.util.Objects;


public class Product implements Comparable<Product> {
    private String id;
    private final String type;
    private final double price;
    private boolean discountAvailable;
    private LocalDate dateAdded;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean discountAvailable) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
    }

    public Product(String type, double price, boolean discountAvailable, LocalDate dateAdded) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = dateAdded;
    }

    public Product(String id, String type, double price, boolean discountAvailable, LocalDate dateAdded) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discountAvailable == product.discountAvailable && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, discountAvailable);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discountAvailable=" + discountAvailable +
                ", dateAdded=" + dateAdded +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }
}
