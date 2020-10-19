<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="resources/bootstrap-3.3.7-dist/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
           <%-- <a class="navbar-brand" href="#">药品类型</a>--%>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">药品信息<span class="sr-only">(current)</span></a>
                </li>
                <li><a href="#">器材归类</a></li>
                <li><a href="/findAllUsers">查询用户</a></li>
                <li><a href="#">价格详情</a></li>
                <li><a href="#">我的设置</a></li>
                <li><a href="#">药品管理</a></li>
                <li><a href="#">信息中心</a></li>
                <li><a href="#">价格详情</a></li>
                <li><a href="#">我的设置</a></li>
                <li><a href="#" style="font-size: 20px">欢迎:&nbsp;&nbsp;${name}&nbsp;&nbsp;&nbsp;登录系统</a></li>

            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
            <table class="table table-striped table-bordered table-hover table-condensed">
                <h2 style="text-align: center">个人信息一览表</h2>
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>密码</td>
                    <td>电话</td>
                    <td>操作</td>

                </tr>

                <c:forEach items="${list}" var="i">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.password}</td>
                        <td>${i.tel}</td>
                        <td><a href="/deleteUserById?id=${i.id}">删除</a>|<a href="#">修改</a></td>

                    </tr>
                </c:forEach>

        </table>


</body>
</html>
