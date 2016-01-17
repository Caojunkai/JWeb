<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/common/reset.css">
    <link rel="stylesheet" href="css/common/supersized.css">
    <link rel="stylesheet" href="css/main/style.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>Login</title>
</head>
<body>
<div class="page-container">
    <h1>登录</h1>
    <form action="<%=request.getContextPath() %>/servlet/LoginServlet" method="post">
        <input type="text" name="username" class="username" placeholder="用户名">
        <input type="password" name="password" class="password" placeholder="密码">
        <button type="submit">提交</button>
        <div class="error"><span>+</span></div>
    </form>
</div>
<script src="js/common/supersized.3.2.7.min.js"></script>
<script src="js/main/shop-bg-init.js"></script>
<script src="./js/login.js"></script>
</body>
</html>
