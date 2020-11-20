<%--
  Created by IntelliJ IDEA.
  User: tonfaions
  Date: 2020/11/12
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传头像</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/upload" method="post" enctype="multipart/form-data">
    <p>
        上传头像<input type="file" name="pic">
    </p>
    <p>
        <input type="submit" value="上传">
    </p>
</form>
</body>
</html>
