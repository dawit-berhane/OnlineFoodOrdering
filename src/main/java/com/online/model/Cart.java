package com.online.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer cust;
    private List<Product> productList;

    public Cart(){
        super();
    }

    public Cart(Customer cust){
        super();
        this.cust = cust;
        productList = new ArrayList<>();
    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public List<Product> getProductList(){
        return productList;
    }
}
