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

        request.getRequestDispatcher("/signup.jsp");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get values from the form

        HttpSession session = request.getSession();

        String userName = request.getParameter("userName") ;
        String firstName = request.getParameter("fname") ;
        String lastName = request.getParameter("lname") ;
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        //check if user already exists

        if(customerDb.get(userName) != null){
            request.setAttribute("error" , "you already have an account ");
            request.getRequestDispatcher("/error.jsp");
            return;
        }

        Customer cust =  new Customer(4, firstName,lastName, userName,password,phone, "");

        customerDAO.addCustomer(cust);
        request.getRequestDispatcher("/menu.jsp").forward(request,response);

    }


}
