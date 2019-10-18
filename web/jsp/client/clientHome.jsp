<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        .table td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="clienttop.jsp"></jsp:include>
<div class="container">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <nav class="navbar navbar-expand-sm bg-light">
                <ul class="navbar-nav" style="width: 100%;">
                    <c:forEach items="${menuClassList}" var="menuClass">
                        <li class="nav-item" style="width:${100/size}%;text-align: center;zoom: 200%">
                            <a class="nav-link" href="${pageContext.request.contextPath}/clienthome?mclass=${menuClass.getMclass()}">${menuClass.getClassName()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>

            <table class="table table-hover table-striped table-bordered" style="text-align: center">
                <tr>
                    <td colspan="5">${addMenuMsg}</td>
                </tr>
                <tr>
                    <td>序号</td>
                    <td>菜名</td>
                    <td>价格</td>
                    <td>库存</td>
                    <td></td>
                </tr>
                <c:forEach items="${menuList}" var="menu" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${menu.getMname()}</td>
                        <td>${menu.getMprice()}</td>
                        <td>${menu.getMamot()}</td>
                        <td><a href="${pageContext.request.contextPath}/clientAddMenu?mId=${menu.getmId()}">添加</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>
