package com.online.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.online.dao.ProductDAO;
import com.online.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutController extends HttpServlet {
    Product menu = new Product();
    ProductDAO menuDb = new ProductDAO();
    Map<String,Product> menus = new HashMap<>();
    List<Product> checkoutList =  new ArrayList<>();
    Gson mapper = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getParameter("checkout");
        //System.out.println(jsonString);
        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonObject jobject = jelement.getAsJsonObject();
        int length = jobject.size();
        System.out.println(length);
        String ordersList;

        menus = menuDb.getAllProducts();
        for(int i =1; i <length-1; i++){
             ordersList = jobject.get(""+i).getAsString();
             menu = menus.get(ordersList);
             //checkoutList.add(menu);
        }
        System.out.println(menu.getDescription());
        HttpSession session = req.getSession();
        session.setAttribute("menu", menu);

        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(menu));

    }
}
