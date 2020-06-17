package com.online.controller;


import com.google.gson.Gson;
import com.online.dao.EmployeeDAO;
import com.online.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;


@WebServlet("/add-employee")
public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeDAO dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/employee.html");
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
           Employee employee = mapper.fromJson(jsonString, Employee.class);
            employee.setEmployeeId(EmployeeDAO.getNextId());
            dao.addEmployee(employee);
            Collection<Employee> employeeItems = dao.getAllEmployee();
            System.out.println(employeeItems);
            resp.getWriter().println(mapper.toJson(employeeItems));
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(ex.toString());
            ex.printStackTrace();
        }
    }
}



