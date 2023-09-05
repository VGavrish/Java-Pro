package org.example;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            List<Order> orders = OrderRepository.getAllOrders();
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(convertOrdersToJson(orders));
            out.flush();
        } else {
            String[] parts = pathInfo.split("/");
            if (parts.length != 2) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            int id = Integer.parseInt(parts[1]);
            Order order = OrderRepository.getOrder(id);
            if (order == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(convertOrderToJson(order));
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 15.0);
        Product product3 = new Product(3, "Product 3", 20.0);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        String idParam = req.getParameter("id");
        String dateParam = req.getParameter("date");
        String costParam = req.getParameter("cost");
        String[] productIds = req.getParameterValues("productIds");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = dateFormat.parse(dateParam);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            System.out.println("Date is " + date);
        }else {
            System.out.println("Incorrect format by date");
        }

        List<Product> orderProducts = new ArrayList<>();
        if (productIds != null) {
            int[] productIdInts = new int[productIds.length];

            for (int i = 0; i < productIds.length; i++) {
                try {
                    productIdInts[i] = Integer.parseInt(productIds[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                for (int productId : productIdInts) {
                    if (productId >= 0 && productId < products.size()) {
                        Product product = products.get(productId);
                        orderProducts.add(product);
                    }
                }
            }
        }else {
            System.out.println("Incorrect product");
        }

        int id = Integer.parseInt(idParam);
        double cost = Double.parseDouble(costParam);

        Order order = new Order(id, date, cost, orderProducts);
        OrderRepository.addOrder(order);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    private String convertOrdersToJson(List<Order> orders) {
        Gson gson = new Gson();
        return gson.toJson(orders);
    }

    private String convertOrderToJson(Order order) {
        Gson gson = new Gson();
        return gson.toJson(order);
    }
}
