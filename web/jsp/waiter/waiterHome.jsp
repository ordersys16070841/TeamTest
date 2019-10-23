<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工主页</title>
    <style>
        .table td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="waitertop.jsp"></jsp:include>
<div class="container">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <h2>待处理的订单</h2>
            <table class="table table-hover table-striped table-bordered" style="text-align: center">
                <tr>
                    <td>序号</td>
                    <td>订单号</td>
                    <td>桌号</td>
                    <td>时间</td>
                    <td></td>
                </tr>
                <c:forEach items="${orderList}" var="order" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${order.getoId()}</td>
                        <td>${order.getDeskId()}</td>
                        <td>${order.getOdate()}</td>
                        <td><a href="${pageContext.request.contextPath}/orderInfo?oId=${order.getoId()}">查看详情</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>
