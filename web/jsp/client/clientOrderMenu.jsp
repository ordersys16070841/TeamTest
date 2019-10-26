<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15513
  Date: 2019/10/21
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订购车</title>
</head>
<body style="background-color: #F5FFFA">
<jsp:include page="clienttop.jsp"></jsp:include>
<div class="container">
    <div class="tab-content">
        <div id="home" class="container tab-pane active" style="background-color: #FBFCFC;margin-left: 40px"><br>
            <h2>我的订购车</h2>
            <form action="cashpay" method="post" class="form-horizontal">
                <table class="table table-hover table-striped table-bordered" style="text-align: center">
                    <tr>
                        <td colspan="5">${removeMenuMsg}${payMsg}</td>
                    </tr>
                    <tr>
                        <td>序号</td>
                        <td>菜名</td>
                        <td>价格</td>
                        <td>数量</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${orderCarList}" var="orderCar" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${orderCar.getMname()}</td>
                            <td>${orderCar.getMprice()}</td>
                            <td>${orderCar.getOmamot()}</td>
                            <td><a href="${pageContext.request.contextPath}/removeMenu?mId=${orderCar.getmId()}">删除</a></td>
                        </tr>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${empty orderCarList}">
                            <tr>
                                <td colspan="5">订购车暂无商品</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td></td>
                                <td></td>
                                <td colspan="2">桌号：</td>
                                <td>
                                    <div style="width: 20px">
                                        <input type="text" name="deskId" class="form-control" style="width: auto" placeholder="桌号范围 1~150"
                                               onchange="if(/\D/.test(this.value)){alert('请正确输入桌号');this.value='';}"/>
                                    </div>

                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td colspan="2">总价：${totalPrice}</td>
                                <td><button type="submit" class="btn btn-outline-primary">现金支付订单</button></td>
                            </tr>

                        </c:otherwise>
                    </c:choose>

                </table>
            </form>


        </div>
    </div>
</div>
</body>
</html>
