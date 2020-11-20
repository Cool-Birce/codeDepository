<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js"></script>
</head>
<body>
<form id="productFrom" action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>商品名称:<input type="text" name="product.name">
                商品价格:<input type="text" name="product.price"></td>
        </tr>
        <tr>
            <td><input type="button" onclick="selectCondition()" value="查询"/>
                <input type="button" onclick="delAll()" value="批量删除" >
                <input type="button" onclick="updateAll()" value="批量修改" ></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1 id="tab">
        <tr>
            <td>商品</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${productList }" var="item" varStatus="status">
            <tr>
                <td><input type="checkbox" name="ids" value="${item.id}">
                    <input type="hidden" name="productList[${status.index }].id" value="${item.id}">
                </td>
                <td><input type="text" name="productList[${status.index }].name" value="${item.name }"></td>
                <td><input type="text" name="productList[${status.index }].price" value="${item.price }"></td>
                <td><input type="text" name="productList[${status.index }].createtime"
                           value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                <td><input type="text" name="productList[${status.index }].detail" value="${item.detail }"></td>
                <td><a href="${pageContext.request.contextPath }/product/itemEdit?id=${item.id}">修改</a></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
<script>
    function delAll() {
        document.getElementById("productFrom").action = "${pageContext.request.contextPath }/product/delAll"
		$("#productFrom").submit();
    }

    function updateAll() {
        document.getElementById("productFrom").action = "${pageContext.request.contextPath }/product/updateAll"
		$("#productFrom").submit();
    }

    function selectCondition() {
        alert("1111")
        var userAndProduct = {};
        var product = {}
        product.name = $("input[name='product.name']").val();
        product.price = $("input[name='product.price']").val();
        userAndProduct.product = product;
        alert(userAndProduct.product.name + "-" + userAndProduct.product.price);
        $.ajax({
            type: "post",
            url: "${pageContext.servletContext.contextPath}/product/selectCondition",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(userAndProduct),
            success: function (data) {
                console.info(data);
                console.log(data[0].id);
                console.log(data[0].createtime);
                var html = "<tr>\n" +
                    "\t<td>商品</td>\n" +
                    "\t<td>商品名称</td>\n" +
                    "\t<td>商品价格</td>\n" +
                    "\t<td>生产日期</td>\n" +
                    "\t<td>商品描述</td>\n" +
                    "\t<td>操作</td>\n" +
                    "</tr>";
                for (var i = 0;i<data.length; i++) {
					console.log(data[i].createtime)
					console.log(data[i].createtime.type)
                    var oDate = new Date(data[i].createtime),
                        oYear = oDate.getFullYear(),
                        oMonth = oDate.getMonth() + 1,
                        oDay = oDate.getDate(),
                        oHour = oDate.getHours(),
                        oMin = oDate.getMinutes(),
                        oSen = oDate.getSeconds(),
                        oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen);//最后拼接时间

                    html += '<tr><td><input type="checkbox" name="ids" value="' + data[i].id + '"><input type="hidden" name="productList[' + i + '].id" value="' + data[i].id + '"> </td>'
                        + '<td><input type="text" name="productList[' + i + '}].name" value="' + data[i].name + '"></td>'
                        + '<td><input type="text" name="productList[' + i + '].price" value="' + data[i].price + '"></td>'
                        + '<td><input type="text" name="productList[' + i + '].createtime" value="' + oTime + '"></td>'
                        + '<td><input type="text" name="productList[' + i + '].detail" value="' + data[i].detail + '"></td>'
                        + '<td><a href="${pageContext.request.contextPath }/product/itemEdit?id=' + data[i].id + '">修改</a></td></tr>'
                }
                $("#tab").html(html);
                return false;
            }, dataType: "json"
        });
    }

    function getzf(num) {
        if (parseInt(num) < 10) {
            num = '0' + num;
        }
        return num;
    }
</script>
</html>