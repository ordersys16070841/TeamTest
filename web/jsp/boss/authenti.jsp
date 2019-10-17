<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/17
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>认证员工账号</title>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="bosstop.jsp"></jsp:include>
<div class="container">
    <form action="" method="post" class="form-horizontal"
          style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
        <table class="table table-striped table-hover">
            <tr>
                <td>序号</td>
                <td>员工账号</td>
                <td>员工昵称</td>
                <td></td>
            </tr>
            <c:forEach items="${waiterList}" var="waiter" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${waiter.getWacot()}</td>
                    <td>${waiter.getWname()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/authenti?wid=${waiter.getWid()}">认证</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
