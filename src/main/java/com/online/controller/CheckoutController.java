package com.online.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.online.dao.CustomerDAO;
import com.online.dao.ProductDAO;
import com.online.model.Cart;
import com.online.model.Customer;
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
import java.util.concurrent.TimeUnit;

public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Product menu;
    ProductDAO menuDb;
    CustomerDAO customerDAO;
    Cart cart;
    Map<String,Product> menus;
    List<Product> checkout;
    Gson mapper = new Gson();
    @Override
    public void init() throws ServletException {
        menu = new Product();
        menuDb = new ProductDAO();
        customerDAO = new CustomerDAO();
        menus = new HashMap<>();
        checkout =  new ArrayList<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getParameter("checkout"); //was checkout
        System.out.println("jsonString : " + jsonString);

        JsonObject jobject = new JsonObject();
        if(jsonString != null) {
            JsonElement jelement = new JsonParser().parse(jsonString);
            jobject = jelement.getAsJsonObject();
        }

            int length = jobject.size();
            System.out.println(length);
            String ordersList;

        HttpSession session = req.getSession();
        Map<String, Customer> customerMap = customerDAO.getCustomerDb();
        String name = (String) req.getSession().getAttribute("userName");
        cart = new Cart(customerMap.get(name));
        session.setAttribute("address", customerMap.get(name).getAddress());

            menus = menuDb.getAllProducts();
            for (int i = 1; i < length ; i++) {
                ordersList = jobject.get("" + i).getAsString();
                menu = menus.get(ordersList);
                checkout.add(menu);
                cart.addProduct(menu); // adding ordered menus to cart data
            }
            System.out.println(menu.getDescription());


            session.setAttribute("checkout", checkout);
            resp.sendRedirect("orderCart.jsp");

    }
}
