<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/css/bootstrap-4.1.2/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/static/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugins/OwlCarousel2-2.3.4/owl.carousel.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugins/OwlCarousel2-2.3.4/owl.theme.default.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/plugins/OwlCarousel2-2.3.4/animate.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main_styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/responsive.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrap-4.1.2/popper.js"></script>
    <script src="${pageContext.request.contextPath}/static/css/bootstrap-4.1.2/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/greensock/TweenMax.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/greensock/TimelineMax.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/scrollmagic/ScrollMagic.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/greensock/animation.gsap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/greensock/ScrollToPlugin.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/OwlCarousel2-2.3.4/owl.carousel.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/jPlayer/jquery.jplayer.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/jPlayer/jplayer.playlist.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/easing/easing.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/progressbar/progressbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/parallax-js-master/parallax.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugins/scrollTo/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
    <script type="text/javascript">
            $(document).ready(function(){
                var y = document.getElementById("na");
                y = y.childNodes[idf];
                $(y).addClass("active");
            });
    </script>

</head>
<body>
<header class="header">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="header_content d-flex flex-row align-items-center justify-content-center">

                    <!-- Logo -->
                    <div class="logo">
                        <a href="#" class="d-flex flex-row align-items-end justify-content-start">
                            <span class="logo_bars d-flex flex-row align-items-end justify-content-between"><span></span><span></span><span></span><span></span><span></span></span>
                            <span class="logo_text">订餐系统</span>
                        </a>
                    </div>

                    <!-- Main Navigation -->
                    <nav class="main_nav">
                        <ul class="d-flex flex-row align-items-center justify-content-start" id="na">
                            <li><a href="${pageContext.request.contextPath}/" >首页</a></li>
                            <li><a href="${pageContext.request.contextPath}/">订购车</a></li>
                            <li><a href="${pageContext.request.contextPath}/">我的订单</a></li>
                            <li><a href="${pageContext.request.contextPath}/">历史订单</a></li>
                        </ul>
                    </nav>

                    <!-- User area -->
                    <div class="log_reg d-flex flex-row align-items-center justify-content-start">
                        <ul class="d-flex flex-row align-items-start justify-content-start navbar-nav">
                            <c:choose>
                                <c:when test="${empty clientname}">
                                    <li><a href="${pageContext.request.contextPath}/">登录</a></li>
                                    <li><a href="${pageContext.request.contextPath}/">注册</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageContext.request.contextPath}/">${clientname}</a></li>
                                    <li><a href="${pageContext.request.contextPath}/logout">注销</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div style="background-image:url(${pageContext.request.contextPath}/static/images/index.jpg);height:134px"></div>
</body>
</html>