<%@ page import="com.drifting.entity.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <%
        Items item = (Items) request.getAttribute("item");
    %>
    <link rel="stylesheet" href="../css/product/product-detail.css">
    <script src="../js/product/product-detail.js"></script>
    <title><%=item.getName() %></title>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="content">
    <div class="goods-detail">
        <div class="goods-detail-img">
            <img src="<%=item.getImgUrl() %>" alt="">
        </div>
        <div class="goods-detail-desc">
            <div class="goods-detail-desc-name">
                <p><%=item.getName() %></p>
                <p>商品产地：<%=item.getProductPlace() %></p>
                <p>品牌：<%=item.getProducer() %></p>
            </div>
            <div class="goods-detail-desc-price">
                <p>价格：￥<%=item.getPrice() %></p>
            </div>
           <div class="goods-detail-order">
               <form action="<%=request.getContextPath() %>/servlet/CartServlet" method="post" name="goods-detail-order">
                   <input type="hidden" name="id" value="<%=item.getId() %>">
                   <input type="hidden" name="action" value="add">
                   <label for="goods-detail-desc-num">购买数量</label>&nbsp;&nbsp;<input type="number" name="num" id="goods-detail-desc-num" value="1"><br />
                   <button type="button" class="btn btn-danger " id="btn-order" >加入购物车</button>
               </form>
           </div>
        </div>
    </div>
</div>
<div class="footer">
</div>
<div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
         aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="loginModalLabel">
                        模态框（Modal）标题
                    </h4>
                </div>
                <div class="modal-body">
                    点击关闭按钮检查事件功能。
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script>
    $(document).ready(function(){
        $("#btn-order").click(function(){
            if (<%=(session.getAttribute("username") == null) %>){
                $("#loginModal").modal("show");
            }else {
                $("form[name='goods-detail-order']").submit();
            }
        });
    });
</script>
</body>
</html>
