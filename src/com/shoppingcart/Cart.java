package com.shoppingcart;

import com.sun.xml.internal.xsom.impl.Const;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Double subTotal = 0.0;
    private Double finalTotal = 0.0;
    private Integer totalApples = 0;
    private Integer totalOranges = 0;
    private Double appleCost = 0.60;
    private Double orangeCost = 0.25;

    public void getCartItems() {

        List<Product> shoppingCart = new Products().getProducts();
        System.out.println("* Shopping Cart Contents *" + "\n");

        for (Product items : shoppingCart) {
            Double itemPrice = items.getPrice();
            String itemName = items.getName();

            setTotalItems(itemName.toUpperCase());
            addToSubTotal(itemPrice);

            printBasketItem(itemName, itemPrice);
        }
        getFinalTotal();

        getFreeItems("APPLE");
        getFreeItems("ORANGE");

        printAllCartInfo();
    }

    private Integer setTotalItems(String item) {
        switch (item) {
            case "APPLE":
                return ++totalApples;
            case "ORANGE":
                return ++totalOranges;
        }
        return null;
    }

    private Double getFinalTotal() {
        return subTotal - getDiscount("APPLE") - getDiscount("ORANGE");

    }

    private Double addToSubTotal(Double itemPrice) {
        return subTotal = subTotal + itemPrice;
    }

    private Integer getFreeItems(String product) {
        Integer freeOranges = 0;
        Integer freeApples = 0;

        switch (product) {
            case "APPLE":
                return freeApples = (totalApples / 2);
            case "ORANGE":
                return freeOranges = (totalOranges / 3);
        }
        return null;
    }

    private Double getDiscount(String product) {
        switch (product) {
            case "APPLE":
                return (totalApples / 2) * appleCost;
            case "ORANGE":
                return (totalOranges / 3) * orangeCost;
        }
        return null;
    };

//    Print functions

    private void printAllCartInfo(){
        printSubTotal();
        printItemTotals();
        printFreeItems();
        printDiscountApplied();
        printFinalTotal();
    }

    private void printBasketItem(String itemName, Double itemPrice) {
        System.out.println("item: " + itemName + " | " + "price: " + itemPrice);

    }

    private void printDiscountApplied() {
        System.out.println(".........................");
        System.out.println("---- Discount Applied ---");
        System.out.println("2 for 1 Apples: -£" + getDiscount("APPLE"));
        System.out.println("3 for 2 Oranges: -£" + getDiscount("ORANGE"));
    }

    private void printFreeItems() {
        System.out.println("freeApples : " + getFreeItems("APPLE"));
        System.out.println("freeOranges : " + getFreeItems("ORANGE"));
    };

    private void printItemTotals() {
        System.out.println("totalApples : " + totalApples );
        System.out.println("totalOranges : " + totalOranges );
    }

    private void printSubTotal() {
        System.out.println(".........................");
        System.out.println("Sub total: £ " + subTotal );
        System.out.println(".........................");
    }

    private void printFinalTotal() {
        System.out.println(".........................");
        System.out.println("Total: £ " + getFinalTotal() );
        System.out.println(".........................");
    }


}
