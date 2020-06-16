package com.online.controller;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.online.dao.ProductDAO;
import com.google.gson.Gson;
import com.online.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO dao;
    Gson mapper = new Gson();
    Map<String, Product> menus;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAO();
        menus= new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //System.out.println(session.getAttribute("userName"));
        String jsonString = req.getParameter("order");
        //System.out.println(jsonString);
        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonObject jobject = jelement.getAsJsonObject();

        String result = jobject.get("order").getAsString();
        //System.out.println(result);
        menus = dao.getAllProducts();
        Product ordered = menus.get(result);

        //System.out.println(ordered.getId());

        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(ordered));
    }
}
