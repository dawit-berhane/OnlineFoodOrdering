package com.online.dao;

import com.online.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {

    Map<String, Product> productDao = new HashMap<>();

    Product menu1 = new Product(1, "Burger", 6, "Burger made with beef and cheese");
    Product menu2 = new Product(2, "Steak", 12, "Steak with rice");
    Product menu3 = new Product(3, "Fish", 20, "grilled fish");

    {
        productDao.put(menu1.getName(), menu1);
        productDao.put(menu2.getName(), menu2);
        productDao.put(menu3.getName(), menu3);
    }

    public Map<String,Product> getAllProducts(){
        return productDao;
    }
}