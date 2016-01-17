package com.drifting.servlet;

import com.drifting.dao.ProductDAO;
import com.drifting.entity.Cart;
import com.drifting.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CartServlet extends HttpServlet {
    private String action;
    private ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null){
            this.action = request.getParameter("action");
        }

        if (action.equals("add")){
            if (addItemToCart(request,response)){
                request.getRequestDispatcher("/jsp/order-success.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/jsp/order-fail.jsp").forward(request,response);
            }
        }
        if (action.equals("show")){
            showCart(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean addItemToCart(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));
        ArrayList<Items> items = productDAO.getItems("",id,"");
        if (items != null && items.size() > 0){
            Items item = items.get(0);
            //判断是否第一次添加 否则创建cart session
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") == null){
                Cart cart = new Cart();
                session.setAttribute("cart",cart);
            }
            Cart cart = (Cart) session.getAttribute("cart");
            return cart.addGoodsToCart(item, num);
        }
        return false;
    }

    private boolean showCart(HttpServletRequest request,HttpServletResponse response){
        return true;
    }


}
