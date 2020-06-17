package com.online.controller;


import com.google.gson.Gson;
import com.online.dao.EmployeeDAO;
import com.online.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = {"/employee", "/employee/*"})
public class EmployeeDataController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private EmployeeDAO dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeType = req.getParameter("type").toUpperCase();
        try {
            resp.setContentType("application/json");
            resp.setBufferSize(4096);
            Collection<Employee> employeeItems = dao.getEmployeeByType(employeeType);
            System.out.println(employeeItems);
            resp.getWriter().println(mapper.toJson(employeeItems));
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(ex.toString());
            ex.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] splittedURI = req.getRequestURI().split("/");
        try {
            Integer itemId = Integer.parseInt(splittedURI[splittedURI.length - 1]);
            Employee toDelete = dao.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
            dao.remove(toDelete);
        } catch(IllegalArgumentException ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println(ex.toString());
        } catch(Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(ex.toString());
            ex.printStackTrace();
        }

    }
}
