package com.shoppingcart;


import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products = new ArrayList<Product>();

    public Products() {
        String [] Names = { "Apple", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Apple" };
        Double [] Prices = { 0.60, 0.60, 0.25, 0.60, 0.25, 0.25, 0.25, 0.60, 0.60};

        //builds list of products
        for (int i=0; i < Names.length; i++) {
            this.products.add(new Product(Names[i], Prices[i]));
        }
    }

    public List<Product> getProducts() {
        return products;
    }

}
