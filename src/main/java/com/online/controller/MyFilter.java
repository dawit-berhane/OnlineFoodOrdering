package com.online.controller;//package Controller;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebFilter("/loginPage")
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("*****************");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        PrintWriter out = response.getWriter();
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String username = req.getParameter("username");
//        String password = req.getParameter("pwd");
//        HttpSession session = req.getSession();
//        System.out.println("2*****************");
//        if (MyDatabase.getUsername().equals(username) && MyDatabase.getPassword().equals(password) && (request.getParameter("rem") != null)) {
//
//            String remember = request.getParameter("rem");
//            System.out.println("remember : " + remember);
//            Cookie cUserName = new Cookie("cookuser", username.trim());
//            Cookie cPassword = new Cookie("cookpass", username.trim());
//            Cookie cRemember = new Cookie("cookrem", remember.trim());
//            cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days
//            cPassword.setMaxAge(60 * 60 * 24 * 15);
//            cRemember.setMaxAge(60 * 60 * 24 * 15);
//            resp.addCookie(cUserName);
//            resp.addCookie(cPassword);
//            //resp.addCookie(cRemember);
//            System.out.println("3*****************");
//        }else {
//            System.out.println("Authentication failure.");
//            //resp.sendRedirect("login.html");
//            session.setAttribute("error_msg", "Invalid email/password");
//            System.out.println("4*****************");
//        }
//        chain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
