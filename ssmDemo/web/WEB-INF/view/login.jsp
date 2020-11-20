<%--
  Created by IntelliJ IDEA.
  User: tonfaions
  Date: 2020/11/10
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/js/jquery-3.1.1.js" type="text/javascript"></script>
</head>
<body>


<p>
    用户名: <input type="text" name="name" placeholder="请输入用户名" required="required">
</p>
<p>
    密码: <input type="password" name="pwd" placeholder="请输入密码" required="required">
</p>
<p>
    <input type="button" value="登录" id="submit">
</p>
<p id="msg"></p>
<script>
    $(function () {
        var user = {};
        $("#submit").click(function () {
            user.username = $('input[name="name"]').val();
            user.password = $('input[name="pwd"]').val();
            alert(user.username + "-" + user.password);
            $.ajax({
                type: "post",
                url: "${ctx}/user/login",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(user),
                success: function (data) {
                    if (data == "1") {
                        alert("qq")
                        window.location.href = "${ctx}/product/findAll";
                        alert("q")
                        return;
                    } else {
                        $("#msg").text(data);
                    }
                },
                dataType: "text"
            })
        })
    })
</script>


</body>
</html>
