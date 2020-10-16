<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 9:35
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

            //id选择器  失去焦点事件
            $("#title").blur(checkTitle);
            $("#content").blur(checkContent);
            $("#type").blur(checkType);

            $("#mytab").submit(function () {
                if (!checkTitle() || !checkContent() || !checkType()) {
                    return false;
                } else {
                    alert("添加成功");
                    return true;
                }

            });

            function checkTitle() {
                var title = $("#title").val();
                if (title == null || title == "") {
                    alert("标题不能为空");
                    return false;
                }
                return true;
            }

            function checkContent() {
                var content = $("#content").val();
                if (content == null || content == "") {
                    alert("内容不能为空");
                    return false;
                }
                return true;
            }

            function checkType() {
                var type = $("#type").val();
                if (type == null || type == "") {
                    alert("请选择类别!");
                    return false;
                }
                return true;
            }
        });
    </script>

</head>
<body>

<form action="WorkingServlet" method="post" id="mytab">

<table width="400px" align="center">
    <tr>
<%--        <td></td>--%>
        <td colspan="2"><strong>我的工作笔记</strong></td>
    </tr>
    <tr>
        <td>标题: </td>
        <td>
            <input type="text" id="title" name="title">
        </td>
    </tr>
    <tr>
        <td>内容: </td>
        <td>
            <textarea rows="5" cols="20" name="content" id="content">

                </textarea>
        </td>
    </tr>
    <tr>
        <td>类别: </td>
        <td>
            <select name="type" id="type">
                <option value="0">请选择类别</option>
                <option value="1">技术</option>
                <option value="2">行政</option>
                <option value="3">人事</option>
            </select>
        </td>
    </tr>
    <tr>
<%--        <td></td>--%>
        <td colspan="2">
            <input type="submit" name="comm" value="提交">
        </td>
    </tr>


</table>

</form>

</body>
</html>
