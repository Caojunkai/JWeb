<%@ page import="java.util.ArrayList" %>
<%@ page import="com.drifting.entity.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jsp/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="goods" class="com.drifting.dao.ProductDAO" scope="session" />
<html>
<head>
    <title>DRIFT SHOP</title>
	<link rel="stylesheet" href="css/main/shop.css">
	<script src="./js/shop.js"></script>
</head>
<body>
<div class="header">
	<%@include file="jsp/navbar.jsp" %>
</div>
<div class="content">
		<div class="goods-list">
			<div class="container-fluid">
			<%
				ArrayList<Items> items =goods.getItems("",0,"");
				int paging = items.size()/4 + 1;
				int p = 0;
				for (int i = 0; i < paging; i++){
			%>
			<div class="row">
				<%
					int k = items.size() - i*4;
					if (k <= 4){
						for (int m = 0; m < k; m++){
				%>
				<a href="<%=request.getContextPath() %>/servlet/ProductServlet?id=<%=items.get(p).getId() %>">
					<div class="col-md-<%=12/k %> good-wrapper">
						<img src="<%=items.get(p).getImgUrl() %>" alt="">
						<span class="good-price">￥<%=items.get(p).getPrice() %></span>
						<span class="good-label"><%=items.get(p).getName() %></span>
					</div>
				</a>
				<%
						p++;
					}
				}else {
					for (int j = 0; j < 4; j++){
				%>
				<a href="<%=request.getContextPath() %>/servlet/ProductServlet?id=<%=items.get(p).getId() %>">
				<div class="col-md-3 good-wrapper">
					<img src="<%=items.get(p).getImgUrl() %>" alt="">
					<span class="good-price">￥<%=items.get(p).getPrice() %></span>
					<span class="good-label"><%=items.get(p).getName() %></span>
				</div>
				</a>
				<%
							p++;
						}
					}
				%>
			</div>
			<%
				}
			%>
		</div>
	</div>
    <div class="visit-history">

    </div>
</div>
</body>
</html>
