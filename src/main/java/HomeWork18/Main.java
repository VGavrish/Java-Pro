package HomeWork18;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Book", 100));
        products.add(new Product("Book", 600));
        products.add(new Product("Book", 100, false));
        products.add(new Product("Book", 100, true));
        products.add(new Product("Book", 260, true));
        products.add(new Product("Book", 270, false));
        products.add(new Product("Book", 10.5, true));
        products.add(new Product("Book3", 12.0, true));
        products.add(new Product("Book4", 8.0, true));
        try {
            products.add(new Product("Book", 8.0, true, LocalDate.of(2022, 5, 10)));
            products.add(new Product("Book", 10.0, true, LocalDate.of(2023, 12, 31)));
            products.add(new Product("Book", 9.0, true, LocalDate.of(2023, 11, 1)));
            products.add(new Product("1", "Book", 280, true, LocalDate.of(2023, 11, 1)));
            products.add(new Product("2", "Book", 281, true, LocalDate.of(2023, 11, 1)));
            products.add(new Product("3", "Toy", 282, true, LocalDate.of(2023, 11, 1)));
            products.add(new Product("4", "Book", 282, true, LocalDate.of(2023, 11, 1)));
        }catch (DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }

        double price = 250;

        //For tasks 1.1 and 1.2
        List<Product> sortByCategoryAndLessPrice = getProductByCategoryAndPriceMoreThat(products, "Book", price);
        System.out.println("Sorted products by category and with price more that: " + price + " " + sortByCategoryAndLessPrice);
        System.out.println("-----------------------------------------------");

        //for 2.1, 2,2
        List<Product> productsWithDiscount = getProductByCategoryWithDiscount(products, "Book", price, true);
        System.out.println("Products with discount: " + productsWithDiscount);
        System.out.println("-----------------------------------------------");

        //for 3.1, 3.2, 3.3
        try {
            Product cheapestBook = getCheapestProductByCategory(products, "Book");
            System.out.println("Cheapest book is: " + cheapestBook);
            System.out.println("-----------------------------------------------");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        //for 4.1, 4,2
        List<Product> latestProducts = getLatestProducts(products);
        System.out.println("Latest added products: ");
        for (Product product : latestProducts) {
            System.out.println(product);
        }
        System.out.println("-----------------------------------------------");

        //for 5.1, 5.2
        double totalPrice = totalPriceOfProducts(products);
        System.out.println("Total price products with price <= 75: " + totalPrice);
        System.out.println("-----------------------------------------------");

        //for 6.1, 6.2
        Map<String, List<Product>> groupedProducts = groupProductsByType(products);
        for(Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
    }


    //For tasks 1.1 and 1.2
    public static List<Product> getProductByCategoryAndPriceMoreThat(List<Product> products, String category, double price) {
        return   products.stream()
                .filter(p -> p.getType().equals(category) && p.getPrice() > price)
                .collect(Collectors.toList());
    }

    //for 2.1, 2,2
    public static List<Product> getProductByCategoryWithDiscount (List<Product> products, String category, double price, boolean isDiscountAvailable) {
        return products.stream()
                .filter(p -> p.getType().equals(category) && p.isDiscountAvailable())
                .map(p -> new Product(p.getType(), p.getPrice() * 0.9, p.isDiscountAvailable()))
                .collect(Collectors.toList());
    }

    //for 3.1, 3.2, 3.3
    public static Product getCheapestProductByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(p -> p.getType().equals(category))
                .min(Product::compareTo)
                .orElseThrow(() -> new RuntimeException("Product [" + category + "] not found"));
    }

    //for 4.1, 4,2
    public static List<Product> getLatestProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getDateAdded() != null)
                .sorted((p1, p2) -> p2.getDateAdded().compareTo(p1.getDateAdded()))
                .limit(3)
                .collect(Collectors.toList());
    }

    //for 5.1, 5.2
    public static double totalPriceOfProducts(List<Product> products) {
        LocalDate currentYear = LocalDate.now().withDayOfYear(1);

        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getDateAdded() != null && p.getDateAdded().isAfter(currentYear))
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    //for 6.1, 6.2
    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }


}
