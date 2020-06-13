package com.online.dao;

import com.online.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO {

    Map<Integer, Product> productDao = new HashMap<>();

    {
        productDao.put(1,  new Product(1, "Burger", 6, "Burger made with beef and cheese"));
        productDao.put(2,  new Product(2, "Steak", 12, "Steak with rice"));
        productDao.put(3,  new Product(3, "Fish", 20, "grilled fish"));

    }
}
