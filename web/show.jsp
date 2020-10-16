<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

        //返回
    function ba() {
    history.back();
    }

    </script>

</head>
<body>


<table align="center" width="500" border="1">
    <tr>
        <td colspan="2">我的工作笔记</td>
<%--        <td></td>--%>
    </tr>
    <tr>
        <td>标题: </td>
        <td>${w.title}</td>
    </tr>
    <tr>
        <td>内容: </td>
        <td>${w.content}</td>
    </tr>
    <tr>
        <td>类别</td>
        <c:if test="${w.type==1}">
            <td width="100">技术</td>
        </c:if>
        <c:if test="${w.type==2}">
            <td width="100">行政</td>
        </c:if>
        <c:if test="${w.type==3}">
            <td width="100">人事</td>
        </c:if>
    </tr>
    <tr>
        <td>日期: </td>
        <td>${w.date}</td>
    </tr>
    <tr>
<%--        <td></td>--%>
        <td colspan="2">
            <input type="button"  value="返回" onclick="ba()">
        </td>
    </tr>


</table>


</body>
</html>
