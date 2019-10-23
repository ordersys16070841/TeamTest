<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/23
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="waitertop.jsp"></jsp:include>
<div class="container">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <h2>订单详情</h2>
            <table class="table table-hover table-striped table-bordered" style="text-align: center">
                <tr>
                    <td>序号</td>
                    <td>菜号</td>
                    <td>菜名</td>
                    <td>数量</td>
                    <td>上菜情况</td>
                    <td></td>
                </tr>
                <c:forEach items="${orderCarList}" var="orderCar" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${orderCar.getmId()}</td>
                        <td>${orderCar.getMname()}</td>
                        <td>${orderCar.getOmamot()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${orderCar.getDeliver() == 0}">
                                    未上菜
                                </c:when>
                                <c:when test="${orderCar.getDeliver() == 1}">
                                    已上菜
                                </c:when>
                            </c:choose>
                        </td>
                        <td><a href="${pageContext.request.contextPath}/servedishes?oId=${oId}&mId=${orderCar.getmId()}">上菜</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
