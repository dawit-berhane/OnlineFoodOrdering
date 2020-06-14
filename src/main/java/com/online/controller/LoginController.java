package com.online.controller;

import com.online.dao.CustomerDAO;
import com.online.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;


public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password =  req.getParameter("password");
        String remember = req.getParameter("remember");

        CustomerDAO customerDAO = new CustomerDAO();
        Map<String, Customer> customerDb = customerDAO.getCustomerDb();

        HttpSession session = req.getSession();
        if(customerDb.get(userName)!= null){
            if("yes".equals(remember)){
                Cookie user_cookie = new Cookie("user", userName);
                user_cookie.setMaxAge(3600 * 60 * 24 * 30);
                resp.addCookie(user_cookie);
            }else{
                Cookie user_cookie = new Cookie("user", null);
                user_cookie.setMaxAge(0);
                resp.addCookie(user_cookie);
            }


            session.setAttribute("userName", customerDb.get(userName).getUserName());
            resp.sendRedirect("menu.jsp");
        }else {
            resp.sendRedirect("login.jsp");
            session.setAttribute("error_msg", "Invalid email/password");

        }
    }
}
