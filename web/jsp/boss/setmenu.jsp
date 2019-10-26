<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/17
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置菜单</title>
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
                        <a class="nav-link" style="color: #d7ffe3" href="${pageContext.request.contextPath}/toMenusInfo">查看菜单</a>
                    </li>
                </ul>
            </nav>
            <form action="addMenuClass" method="post" class="form-horizontal"
                  style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
                <table class="table table-hover table-striped table-bordered" style="text-align: center">
                    <thead><h3>添加菜单类别</h3></thead>
                    <tr>
                        <td>菜单类别</td>
                        <td><input type="text" class="form-control" placeholder="菜单类别" name="className"
                                   onchange="if(/[^\u4e00-\u9fa5]/g.test(this.value)){alert('请正确输入菜单类别');this.value='';}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">${menuClassMsg}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn btn-outline-primary">添加菜单类别</button>
                        </td>
                    </tr>
                </table>
            </form>
            <form action="addMenu" method="post" class="form-horizontal"
                  style="margin-left: 10%;margin-right: 10%;margin-top: 7%;margin-bottom: 7%">
                <table class="table table-hover table-striped table-bordered" style="text-align: center">
                    <thead><h3>添加菜单</h3></thead>
                    <tr>
                        <td>菜单名字</td>
                        <td><input type="text" class="form-control" placeholder="菜单名字" name="mname"
                                   onchange="if(/[^\u4e00-\u9fa5]/g.test(this.value)){alert('请正确输入菜单名字');this.value='';}" /></td>
                    </tr>
                    <tr>
                        <td>菜单成本</td>
                        <td><input type="text" class="form-control price" placeholder="菜单成本" name="mcost"/></td>
                    </tr>
                    <tr>
                        <td>菜单价格</td>
                        <td><input type="text" class="form-control price" placeholder="菜单价格" name="mprice"/></td>
                    </tr>
                    <tr>
                        <td>菜单分类</td>
                        <td>
                            <select id="uquest" name="mclass" class="form-control" style="color: #000000" >
                                <c:forEach items="${menuClassList}" var="menuClass">
                                    <option value="${menuClass.getMclass()}">${menuClass.getClassName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">${addMenuMsg}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn btn-outline-primary">添加菜单</button>
                        </td>
                    </tr>
                </table>
            </form>


        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/boss/boss.js"></script>
</html>
