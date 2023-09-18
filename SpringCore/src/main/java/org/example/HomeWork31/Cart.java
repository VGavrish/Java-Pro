package org.example.HomeWork31;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {
        products.remove(id);
    }

    public List<Product> getAllProduct() {
        return products;
    }
}
