<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/17
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看菜单</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="bosstop.jsp"></jsp:include>
<div class="container" style="margin-left:10%;margin-right:10%;margin-bottom:7%;margin-top: 2%">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <nav class="navbar navbar-expand-sm bg-light">
                <!-- Links -->
                <ul class="navbar-nav" style="width: 100%;">
                    <li class="nav-item active" style="width: 50%;text-align: center;zoom: 200%">
                        <a class="nav-link" href="${pageContext.request.contextPath}/toSetMenu">设置菜单</a>
                    </li>
                    <li class="nav-item" style="width: 50%;text-align: center;zoom: 200%;background-color: #428bca">
                        <a class="nav-link" style="color: #d7ffe3"
                           href="${pageContext.request.contextPath}/toMenusInfo">查看菜单</a>
                    </li>
                </ul>
            </nav>

            <table class="table table-hover table-striped table-bordered" style="text-align: center">
                <thead><h3>总菜单</h3></thead>
                <tr><td colspan="7">${menuInfoMsg}</td></tr>
                <tr>
                    <td>序号</td>
                    <td>菜名</td>
                    <td>菜类</td>
                    <td>成本</td>
                    <td>售价</td>
                    <td>库存</td>
                    <td></td>
                </tr>
                <c:forEach items="${menuList}" var="menu" varStatus="status">
                    <tr>
                        <form action="modifyMenu" method="post">
                            <input type="hidden" class="form-control" value="${menu.getmId()}" name="mId"/>

                            <td>${status.count}</td>
                            <td>${menu.getMname()}</td>
                            <td>${menu.getClassName()}</td>
                            <td><input type="text" class="form-control price" value="${menu.getMcost()}" name="mcost"/></td>
                            <td><input type="text" class="form-control price" value="${menu.getMprice()}" name="mprice"/></td>
                            <td><input type="text" class="form-control" value="${menu.getMamot()}" name="mamot"
                                       onchange="if(/\D/.test(this.value)){alert('请正确输入库存');this.value='';}"/></td>
                            <td>
                                <button type="submit" class="btn btn-outline-primary">修改</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/boss/boss.js"></script>
</html>
