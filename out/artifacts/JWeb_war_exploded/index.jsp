<%@ page import="java.util.ArrayList" %>
<%@ page import="com.drifting.entity.Users" %>
<%@ page import="com.drifting.dao.UsersDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./jsp/header.jsp" %>
<html>
<head>
  <title>wqe</title>
</head>
<body>
<%
  UsersDAO usersDAO = new UsersDAO();
  ArrayList<Users> list = usersDAO.getUsers();
%>
<div>
  <%
    for (Users user : list) {
  %>
  <ul>
    <li>ID:<%=user.getId() %>
    </li>
    <li>Name:<%=user.getName() %>
    </li>
    <li>Password:<%=user.getPassword() %>
    </li>
    <li>Email:<%=user.getEmail() %>
    </li>
    <li>Sex:<%=user.getSex() %>
    </li>
    <li>Ctime:<%=user.getCtime() %>
    </li>
    <li>Face:<%=user.getEmail() %>
    </li>
  </ul>
  <%
    }
  %>
</div>
</body>
</html>
