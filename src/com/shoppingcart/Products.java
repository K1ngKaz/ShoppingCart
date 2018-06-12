package com.shoppingcart;


import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products = new ArrayList<Product>();
    public static List<String> productTypes = new ArrayList<String>();

    public Products() {
        initCartItems();
    }

    private void initCartItems(){
        String [] Names = { "APPLE", "BANANA", "ORANGE", "APPLE","BANANA","Banana","BANANA", "ORANGE", "ORANGE", "ORANGE", "APPLE", "APPLE" };
        Double [] Prices = { 0.60, 0.20, 0.25, 0.60, 0.20, 0.20, 0.20, 0.25, 0.25, 0.25, 0.60, 0.60};

        //builds list of products
        for (int i=0; i < Names.length; i++) {
            this.products.add(new Product(Names[i], Prices[i]));
            if(!productTypes.contains(Names[i])){
                productTypes.add(Names[i]);
            }
        }
    }

    List<Product> getProducts() {
        return products;
    }

    static List<String> getProductTypes() {
        return productTypes;
    }
}
