package com.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public void printCartItems() {
        Double subTotal = 0.0;
        Double finalTotal = 0.0;
        Integer totalApples = 0;
        Integer totalOranges = 0;
        Integer freeApples = 0;
        Integer freeOranges = 0;

        Double appleCost = 0.60;
        Double orangeCost = 0.25;

        List<Product> shoppingCart = new Products().getProducts();
        System.out.println("* Shopping Cart Contents *" + "\n");

        for (Product items : shoppingCart) {
            Double itemPrice = items.getPrice();
            String itemName = items.getName();

            if (itemName.equals("Apple")) {
                ++totalApples;
            }

            if (itemName.equals("Orange")) {
                ++totalOranges;
            }

            subTotal = subTotal + itemPrice;
            System.out.println("item: " + itemName + " | " + "price: " + itemPrice);
        }

        freeApples = totalApples / 2;
        freeOranges = totalOranges / 3;

        Double appleDiscount = freeApples * appleCost;
        Double orangeDiscount = freeOranges * orangeCost;

        finalTotal = subTotal - appleDiscount - orangeDiscount;

        System.out.println(".........................");
        System.out.println("Sub total: £ " + subTotal);
        System.out.println(".........................");

        System.out.println("totalApples : " + totalApples);
        System.out.println("totalOranges : " + totalOranges);

        System.out.println("freeApples : " + freeApples);
        System.out.println("freeOranges : " + freeOranges);

        System.out.println(".........................");
        System.out.println("---- Discount Applied ---");
        System.out.println("2 for 1 Apples: £ " + appleDiscount);
        System.out.println("3 for 2 Oranges: £ " + orangeDiscount);
        System.out.println(".........................");
        System.out.println("Total: £ " + finalTotal);
        System.out.println(".........................");

    }

}
