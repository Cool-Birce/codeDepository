<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${ctx}/bootstrap-4.5.0-dist/css/bootstrap.css" crossorigin="anonymous">

    <title>Mybatis</title>
</head>
<body class="bg-secondary text-white">
<div class="container ">
    <form action="${ctx}/addUser" method="post">
        <div class="row">

            <div class="col-md-6 offset-3" style="margin-top: 200px">
                <h1 class="font-weight-bold text-monospace">注册界面</h1>
                <div class="form-group row">
                    <label for="name1" class="col-md-2 col-form-label" style="text-align: right" >用户名</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="name1" aria-describedby="emailHelp"
                               placeholder="请输入用户名" name="name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleInputPassword1" class="col-md-2 col-form-label" style="text-align: right">密码</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="pwd">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleInputEmail2" class="col-md-2 col-form-label" style="text-align: right">描述</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" placeholder="我想起了开心的事" name="url">
                    </div>
                </div>
                <div class="form-group row">

                    <div class="col-md-5 offset-md-2">
                        <button type="submit" class="btn btn-outline-success btn-md">注册</button>
                        <button type="reset" class="btn btn-outline-success btn-md">重置</button>
                    </div>
                </div>
            </div>
            <c:if test="${msg!=null}">
                <div class="alert alert-danger alert-dismissible fade show col-md-5 offset-md-4" role="alert">
                    <strong>注册失败!</strong>${msg}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
        </div>
    </form>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="${ctx}/bootstrap-4.5.0-dist/js/jquery-3.1.1.js" crossorigin="anonymous"></script>
    <script src="${ctx}/bootstrap-4.5.0-dist/js/bootstrap.js" crossorigin="anonymous"></script>
    <script>
    </script>
</body>
</html>
