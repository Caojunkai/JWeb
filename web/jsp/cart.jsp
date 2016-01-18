<%@ page import="com.drifting.entity.Cart" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.drifting.entity.Items" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    HashMap<Items, Integer> goods = cart.getGoods();
    double totalPrice = cart.getTotalPrice();
%>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<div class="header">
    <%@include file="navbar.jsp" %>
</div>
<div class="content">
    <div class="container-fluid">
        <%
            if (goods != null && goods.size() > 0){
                Set<Map.Entry<Items, Integer>> items = goods.entrySet();
                Iterator<Map.Entry<Items, Integer>> iterator = items.iterator();
                while (iterator.hasNext()){
                    Map.Entry<Items, Integer> i = iterator.next();
                    String imgUrl = i.getKey().getImgUrl();
                    String name = i.getKey().getName();
                    double price = i.getKey().getPrice();
                    int num = i.getValue();
                    double sum = i.getKey().getPrice() * i.getValue();


        %>
                    <div class="row">
                        <div class="col-md-3">
                            <img src="<%=imgUrl %>" alt="">
                        </div>
                        <div class="col-md-3">
                            <%=name %>
                        </div>
                        <div class="col-md-2">
                            <%=price %>
                        </div>
                        <div class="col-md-2">
                            <%=num %>
                        </div>
                        <div class="col-md-2">
                            <%=sum %>
                        </div>
                    </div>
        <%
                }
        %>
        <%
            } else {
        %>
            <div class="row">
                <div class="col-md-12">
                    <h1>购物车为空</h1>
                </div>
            </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
