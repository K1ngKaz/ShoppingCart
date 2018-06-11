package com.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public void printCartItems() {
        Double totalPrice = 0.0;

        List<Product> shoppingCart = new Products().getProducts();
        System.out.println("* Shopping Cart Contents *" + "\n");

        for (Product items : shoppingCart) {
            Double price = items.getPrice();
            String name = items.getName();
            totalPrice = totalPrice + price;
            System.out.println("item: " + name + " | " + "price: " + price);
        }
        System.out.println(".........................");
        System.out.println("Total: " + totalPrice);
        System.out.println(".........................");

    }

}
