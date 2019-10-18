<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        .table td{
            text-align: center;
            vertical-align: middle!important;
        }
    </style>
</head>
<body style="background-color: #F5FFFA">
<c:choose>
    <c:when test="${empty waiterName}">
        <jsp:forward page="${pageContext.request.contextPath}/toWaiterLogin">
            <jsp:param name="loginMsg" value="请先进行登录" />
        </jsp:forward>
    </c:when>
</c:choose>

<jsp:include page=""></jsp:include>
<div class="container">
    <form action="register" method="post" enctype="multipart/form-data" class="form-horizontal"
          style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
        <table class="table table-striped table-hover">

        </table>
    </form>
</div>



</body>
</html>
