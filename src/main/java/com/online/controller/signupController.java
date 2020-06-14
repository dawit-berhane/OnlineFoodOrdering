package com.online.controller;

import com.online.dao.CustomerDAO;
import com.online.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class signupController extends HttpServlet {

    CustomerDAO customerDAO = new CustomerDAO();
    Map<String, Customer> customerDb = customerDAO.getCustomerDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     request.getRequestDispatcher("resources/signup.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get values from the form

        String firstName = request.getParameter("fname") ;
        String lastName = request.getParameter("lname") ;
        String userName = request.getParameter("userName") ;
      //  String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        //check if user already exists

        if(customerDAO.getCustomerDb() != null){
            request.setAttribute("error" , "User is already registered");
            request.getRequestDispatcher("resources/login.jsp");
            return;
        }

        Customer cust =  new Customer(4, firstName,lastName, userName,password,phone, "");

        customerDAO.addCustomer(cust);
        request.getRequestDispatcher("resources/menu.jsp").forward(request,response);

    }

}