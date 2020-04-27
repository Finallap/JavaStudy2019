<%--
  Created by IntelliJ IDEA.
  User: Finallap
  Date: 2020/4/26
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>提交的学生信息如下</h2>
<table>
    <tr>
        <td>编号：</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>年龄：</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>是否接收论文？</td>
        <td>${receivePaper}</td>
    </tr>
    <tr>
        <td>喜欢的技术/框架</td>
        <td>
            <% String[] favoriteFramework = (String[]) request.getAttribute("favoriteFramework");
                for (String framework : favoriteFramework) {
                    out.println(framework);
                }
            %>
        </td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${(gender=="M"?"男":"女")}</td>
    </tr>
</table>
</body>
</html>
