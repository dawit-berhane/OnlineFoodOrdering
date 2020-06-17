package com.online.controller;


import com.google.gson.Gson;
import com.online.dao.FoodDAO;
import com.online.model.Food;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;


@WebServlet("/add-food")
public class FoodController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FoodDAO dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new FoodDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/addfood.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        resp.setContentType("application/json");
        resp.setBufferSize(4096);
        try (BufferedReader bufferedReader = req.getReader()) {
            while ( (line = bufferedReader.readLine()) != null) stringBuffer.append(line);
            String jsonString = stringBuffer.toString();
            Food food = mapper.fromJson(jsonString, Food.class);
            food.setFoodId(FoodDAO.getNextId());
            dao.addFood(food);

            Collection<Food> foodItems = dao.getAllFood();
            System.out.println(foodItems);
            resp.getWriter().println(mapper.toJson(foodItems));
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(ex.toString());
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        resp.setContentType("application/json");
        resp.setBufferSize(4096);
        try (BufferedReader bufferedReader = req.getReader()) {
            while ( (line = bufferedReader.readLine()) != null) stringBuffer.append(line);
            String jsonString = stringBuffer.toString();
            Food food = mapper.fromJson(jsonString, Food.class);
            dao.addFood(food);
            Collection<Food> foodItems = dao.getAllFood();
            System.out.println(foodItems);
            resp.getWriter().println(mapper.toJson(foodItems));
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(ex.toString());
            ex.printStackTrace();
        }
    }
}



