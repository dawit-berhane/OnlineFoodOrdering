package com.online.controller;

import com.online.model.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPage")
public class AdminLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("webapp/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        // req.getRequestDispatcher("WEB-INF/views/loginSuccess.jsp").forward(req,resp);
        if (Admin.getUsername().equals(username) && Admin.getPassword().equals(password) && (req.getParameter("rem") != null)) {
        //if (MyDatabase.getUsername().equals(username) && this.password.equals(password)) {
            //get the old session and invalidate
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = req.getSession(true);

            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);

            Cookie message = new Cookie("message", "Welcome");
            resp.addCookie(message);
            resp.sendRedirect("adminloginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("webapp/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(req, resp);
        }
    }




}
