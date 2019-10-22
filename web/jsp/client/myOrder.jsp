<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/22
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="clienttop.jsp"></jsp:include>
<div class="container">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <c:choose>
                <c:when test="${empty cId}">
                    <center>
                        <h2>请先进行登录</h2>
                    </center>
                </c:when>
                <c:otherwise>
                    <h2>我的订单</h2>
                    <table class="table table-hover table-striped table-bordered" style="text-align: center">
                        <tr align="left">
                            <td colspan="7">
                                <h4>订单信息</h4>
                            </td>
                        </tr>
                        <tr>
                            <td>订单号</td>
                            <td>服务员ID</td>
                            <td>桌号</td>
                            <td>支付方式</td>
                            <td>时间</td>
                            <td>状态</td>
                            <td>总价</td>
                        </tr>
                        <tr>
                            <td>${order.getoId()}</td>
                            <td>${order.getwId()}</td>
                            <td>${order.getDeskId()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.getPay() == 3}">
                                        现金支付
                                    </c:when>
                                    <c:otherwise>
                                        其它
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${order.getOdate()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.getStatus() == 0}">
                                        未完成
                                    </c:when>
                                    <c:when test="${order.getStatus() == 0}">
                                        已完成
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>${order.getTotal()}</td>
                        </tr>
                        <tr></tr>
                        <tr align="left">
                            <td colspan="7"><h4>订单内容</h4></td>
                        </tr>
                        <tr>
                            <td>菜号</td>
                            <td>菜名</td>
                            <td>数量</td>
                            <td>单价</td>
                            <td>已上菜</td>
                        </tr>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>


</body>
</html>
