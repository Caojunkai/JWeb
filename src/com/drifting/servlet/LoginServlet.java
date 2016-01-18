package com.drifting.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath() + "/shop.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        String result;
        if ("admin".equals(username) && "admin".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            result = "{\"msg\":\"1\"}";
        }else {
            result = "{\"msg\":\"0\"}";
        }
        out.write(result);
    }
}
