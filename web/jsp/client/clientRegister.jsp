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
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrap-4.1.2/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/css/bootstrap-4.1.2/bootstrap.min.css">

</head>
<body style="background-color: #F5FFFA">
<div class="page-header" style="margin-top: 50px">
    <center>
        <h1>账号注册界面</h1>
    </center>
</div>
<div class="container">
    <form action="clientRegister" method="post" class="form-horizontal"
          style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
        <table class="table table-striped table-hover">
            <tr>
                <td>账号名：</td>
                <td><input type="text" class="form-control" placeholder="账号名" name="cacot"/></td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" class="form-control" placeholder="昵称" name="cname"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" class="form-control" placeholder="密码" name="cpsd" /></td>
            </tr>
            <tr>
                <td colspan="2">${registerMsg}</td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit" class="btn btn-outline-primary">客户注册</button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
