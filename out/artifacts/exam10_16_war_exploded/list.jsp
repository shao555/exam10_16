<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
            $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
            $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素
            $("table").css("width", "600px")
        }); //为表格添加样式，设置表格长度为300像素
    </script>

</head>
<body>

<h1 align="center">工作笔记</h1>

<a href="add.jsp">添加笔记</a>

<table align="center" width="500" border="1">
    <tr>
        <td><strong>笔记标题</strong></td>
        <td><strong>笔记分类</strong></td>
        <td><strong>编写时间</strong></td>
        <td><strong>操作</strong></td>
    </tr>

    <c:forEach var="w" items="${list}">
        <tr>
            <td>${w.title}</td>
            <td>${w.type}</td>
            <td>${w.date}</td>
            <td>
                <a href="WorkingServlet?id=${w.id}&comm=se">查看</a>
            </td>
        </tr>
    </c:forEach>


</table>


</body>
</html>
