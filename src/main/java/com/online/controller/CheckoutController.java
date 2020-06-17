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
import java.util.concurrent.TimeUnit;

public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Product menu;
    ProductDAO menuDb;
    Map<String,Product> menus;
    List<Product> checkout;
    Gson mapper = new Gson();
    @Override
    public void init() throws ServletException {
        menu = new Product();
        menuDb = new ProductDAO();
        menus = new HashMap<>();
        checkout =  new ArrayList<>();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        menu = (Product) session.getAttribute("food");
//        req.setAttribute("checkout",menu);
//        RequestDispatcher view = req.getRequestDispatcher("orderCart.jsp");
//        view.forward(req, resp);

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

            menus = menuDb.getAllProducts();
            for (int i = 1; i < length ; i++) {
                ordersList = jobject.get("" + i).getAsString();
                menu = menus.get(ordersList);
                checkout.add(menu);
            }
            System.out.println(menu.getDescription());
            HttpSession session = req.getSession();
//        session.setAttribute("menu", menu);

            //PrintWriter out = resp.getWriter();
            //out.print(mapper.toJson(menu));

            //req.setAttribute("checkout", menu);
            session.setAttribute("checkout", checkout);
            //RequestDispatcher requestDispatcher = req.getRequestDispatcher("orderCart.jsp");
            resp.sendRedirect("orderCart.jsp");
            //requestDispatcher.forward(req, resp);

    }
}
