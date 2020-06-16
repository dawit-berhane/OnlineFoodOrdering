package com.online.controller;

import com.online.dao.CustomerDAO;
import com.online.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


public class SignupController extends HttpServlet {

    CustomerDAO customerDAO = new CustomerDAO();
    Map<String, Customer> customerDb = customerDAO.getCustomerDb();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // get values from the form

        HttpSession session = request.getSession();

        String userName = request.getParameter("userName");

        if(userName.equals("mesfin")) {
            session.setAttribute("userName" , userName);
            response.sendRedirect("loginsecond.jsp");
        }
        else{

            String userame = request.getParameter("userName") ;
            String firstName = request.getParameter("fname") ;
            String lastName = request.getParameter("lname") ;
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            Customer cust =  new Customer(4, firstName,lastName, userame,password,phone, "");
            customerDAO.addCustomer(cust);
            
            response.sendRedirect("menu.jsp");
        }

    }
}







