package com.drifting.servlet;

import com.drifting.dao.ProductDAO;
import com.drifting.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Items> items = productDAO.getItems("",id,"");
        if (items != null && items.size() > 0){
            Items item = items.get(0);
            request.setAttribute("item",item);
            request.getRequestDispatcher("/jsp/product.jsp").forward(request,response);
        }else {
            response.sendRedirect("/JWeb/shop.jsp");
        }
    }
}
