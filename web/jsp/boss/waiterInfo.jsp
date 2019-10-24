<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/24
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息</title>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="bosstop.jsp"></jsp:include>
<div class="container">
    <nav class="navbar navbar-expand-sm bg-light">
        <!-- Links -->
        <ul class="navbar-nav" style="width: 100%;">
            <li class="nav-item active" style="width: 50%;text-align: center;zoom: 200%">
                <a class="nav-link" href="${pageContext.request.contextPath}/toAuthenti">认证员工</a>
            </li>
            <li class="nav-item" style="width: 50%;text-align: center;zoom: 200%;background-color: #428bca">
                <a class="nav-link" style="color: #d7ffe3"
                   href="${pageContext.request.contextPath}/myWaiters">员工信息</a>
            </li>
        </ul>
    </nav>
    <form action="" method="post" class="form-horizontal"
          style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
        <table class="table table-striped table-hover">
            <tr>
                <td>序号</td>
                <td>员工账号</td>
                <td>员工昵称</td>
                <td>状态</td>
            </tr>
            <c:forEach items="${waiterList}" var="waiter" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${waiter.getWacot()}</td>
                    <td>${waiter.getWname()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${waiter.getWstatus()==1}">
                                离线
                            </c:when>
                            <c:when test="${waiter.getWstatus()==2}">
                                <p style="color: #1fda1f">在线</p>
                            </c:when>

                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
