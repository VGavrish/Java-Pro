package org.example;

import org.example.HomeWork31.AppConfig;
import org.example.HomeWork31.Cart;
import org.example.HomeWork31.Product;
import org.example.HomeWork31.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        productRepository.getProducts().add(new Product(1, "Product1", 10.0));
        productRepository.getProducts().add(new Product(2, "Product2", 11.0));

        List<Product> allProducts = productRepository.getAllProducts();
        System.out.println("All products");
        for (Product product : allProducts) {
            System.out.println(product);
        }

        cart.addProduct(allProducts.get(0));
        cart.addProduct(allProducts.get(1));
        cart.removeProduct(0);


        context.close();
    }
}