<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gec.bean.User" %>
<%@ page import="com.gec.bean.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: tonfaions
  Date: 2020/10/27
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

用户名:${user.userName}<br/>
<form action="loginForm.action" method="post">

<%
    PageBean<User> pagebean=(PageBean<User>) request.getAttribute("pagebean");
    for(User s:pagebean.getList()){
%>
   用户信息<%=s%><a href="update.jsp?user="+<%=s%>>修改</a><a href="delete.action?id="+<%=s.getId()%>>删除</a><br/>
<%
    }
%>
<%
if(pagebean.getPageNow()>1){
    %>
<a onclick="">首页</a><a onclick="">上一页</a>
<%}else{%>
首页&nbsp;&nbsp;上一页
<%}%>
<%
if(pagebean.getPageNow()<pagebean.getPageCount()){
    %>
<a onclick="">下一页</a><a onclick="">末页</a>
<%}else{%>
下一页&nbsp;&nbsp;末页
<%}%>
</form>
</body>
<script>
    function find(PageNow) {

    }

</script>
</html>
