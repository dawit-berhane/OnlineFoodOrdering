package com.online.controller;

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
        req.getRequestDispatcher("WEB-INF/views/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");

        if (MyDatabase.getUsername().equals(username) && MyDatabase.getPassword().equals(password) && (req.getParameter("rem") != null)) {

            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);


            newSession.setMaxInactiveInterval(24*30*60);

            Cookie message = new Cookie("message", "Welcome");
            resp.addCookie(message);
            req.getRequestDispatcher("WEB-INF/views/loginSuccess.jsp").forward(req,resp);
            //resp.sendRedirect("WEB-INF/views/loginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("WEB-INF/views/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(req, resp);
        }
    }




}
