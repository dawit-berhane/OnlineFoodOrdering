package com.online.controller;
import com.online.dao.ProductDAO;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OrderController extends HttpServlet {
    private ProductDAO dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getParameter("order");
        System.out.println(jsonString);
    }
}
