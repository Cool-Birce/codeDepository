<%--
  Created by IntelliJ IDEA.
  User: tonfaions
  Date: 2020/10/27
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update.action" method="post">
    <input type="hidden" name="id" value=${user.id}>
    用户名:<input name="userName" value="${user.userName}">
    密码:<input name="pwd" type="password" value="${user.userPassword}">
    描述:<input name="email" value="${user.userUrl}">
    <input type="submit" value="提交">
</form>

</body>
</html>
