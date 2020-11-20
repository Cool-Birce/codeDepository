<%--
  Created by IntelliJ IDEA.
  User: tonfaions
  Date: 2020/11/9
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="${pageContext.servletContext.contextPath}/index">
    用户名:<input name="name" placeholder="请输入姓名" required="required">
    密码:<input type="password" name="pwd" placeholder="请输入密码" required="required">
    <input type="submit" value="登录">
  </form>
  </body>
</html>
