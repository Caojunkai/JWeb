<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        .content-label span{
            font-size: x-large;
            color: #7ABD54;
            float: left;
            margin-left: 20px;
        }
        .content-label a{
            float: left;
            width: 200px;
            font-size: medium;
            margin-left: 30px;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="content">
    <div class="content-label">
        <span>√&nbsp;&nbsp;添加购物车成功</span>
        <a href="./cart.jsp" class="btn btn-danger">查看购物车</a>
    </div>

</div>
</body>
</html>
