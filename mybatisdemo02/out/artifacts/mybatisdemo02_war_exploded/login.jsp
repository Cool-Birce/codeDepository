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

    <title>Hello, world!</title>
</head>
<body>
<h1>Hello, world!</h1>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${ctx}/bootstrap-4.5.0-dist/js/jquery-3.1.1.js" crossorigin="anonymous"></script>
<script src="${ctx}/bootstrap-4.5.0-dist/js/bootstrap.js" crossorigin="anonymous"></script>
</body>
</html>