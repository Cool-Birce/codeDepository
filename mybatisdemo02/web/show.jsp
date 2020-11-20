<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>展示界面</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all">
</head>
<body>
<p>欢迎,用户:${sessionScope.user.userName} </p>
<table id="demo" lay-filter="test"></table>

<script src="${ctx}/layui/layui.js"></script>
<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '${ctx}/findAll' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'userName', title: '用户名', width:80}
                ,{field: 'userPassword', title: '密码', width:80, sort: true}
                ,{field: 'userUrl', title: '描述', width:80, sort: true}

            ]]
            ,limit:3
            ,limits:[3,6,9]
        });

    });
</script>
</body>
</html>
