package com.shoppingcart;

import com.sun.xml.internal.xsom.impl.Const;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Double subTotal = 0.00;
    private Double finalTotal = 0.00;
    private Integer totalApples = 0;
    private Integer totalOranges = 0;
    private Integer totalBananas = 0;
    private Double appleCost = 0.60;
    private Double orangeCost = 0.25;
    private Double bananaCost = 0.20;
    private Double runningTotal = 0.00;
    private Integer freeOranges = 0;
    private Integer freeApples = 0;
    private Integer freeBananas = 0;

    public void getCartItems() {



        List<Product> shoppingCart = new Products().getProducts();
        System.out.println("* Shopping Cart Contents *" + "\n");

        for (Product items : shoppingCart) {
            Double itemPrice = items.getPrice();
            String itemName = items.getName();

            setTotalItems(itemName.toUpperCase());
            addToSubTotal(itemPrice);

            printBasketItem(itemName, itemPrice, updateRunningTotal(itemPrice));
        }
        getFinalTotal();

        getFreeItems("APPLE");
        getFreeItems("ORANGE");
        getFreeItems("BANANA");

        printAllCartInfo();
    }

    private Double updateRunningTotal(Double itemPrice) {
        runningTotal = runningTotal + itemPrice;
        return round(runningTotal);
    }

    private static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private Integer setTotalItems(String item) {
        switch (item) {
            case "APPLE":
                return ++totalApples;
            case "ORANGE":
                return ++totalOranges;
            case "BANANA":
                return ++totalBananas;
        }
        return null;
    }

    private Double getFinalTotal() {
        double subT = subTotal - getDiscount("APPLE") - getDiscount("ORANGE") - getDiscount("BANANA");
        return round(subT);
    }

    private Double addToSubTotal(Double itemPrice) {
        subTotal = subTotal + itemPrice;
        return round(subTotal);
    }

    private void getFreeItems(String product) {
        Integer totalAppleBanana = 0;
        Integer totalFree = 0;

        if (product.equals("ORANGE")) {
            freeOranges =  (totalOranges / 3);
        } else {
            totalFree = (totalApples + totalBananas) / 2;
                if (totalApples >= totalBananas) {
                    freeBananas = totalBananas;
                    freeApples = totalFree - freeBananas;
                } else {
                    freeBananas = totalFree;
                }
        }
    }


    private Double getDiscount(String product) {
        switch (product) {
            case "APPLE":
                return freeApples * appleCost;
            case "ORANGE":
                return freeOranges * orangeCost;
            case "BANANA":
                return freeBananas * bananaCost;
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

    private void printBasketItem(String itemName, Double itemPrice, Double runningTotal) {
        System.out.println("item: " + itemName + " | " + "price: " + itemPrice+ " | " + "price: " + runningTotal);

    }

    private void printDiscountApplied() {
        System.out.println(".........................");
        System.out.println("---- Discount Applied ---");
        System.out.println("2 for 1 Apples: -£" + getDiscount("APPLE"));
        System.out.println("3 for 2 Oranges: -£" + getDiscount("ORANGE"));
        System.out.println("2 for 1 Bananas: -£" + getDiscount("BANANA"));
    }

    private void printFreeItems() {
        System.out.println("freeApples : " + freeApples);
        System.out.println("freeOranges : " + freeOranges);
        System.out.println("freeBananas : " + freeBananas);
    };

    private void printItemTotals() {
        System.out.println("totalApples : " + totalApples );
        System.out.println("totalOranges : " + totalOranges );
        System.out.println("totalBananas : " + totalBananas );
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
