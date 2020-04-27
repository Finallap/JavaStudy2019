<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Finallap
  Date: 2020/4/25
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>Student Information</h2>
<form:form method="POST" action="/SpringMVCStart_war/addStudent">
    <table>
        <tr>
            <td><form:label path="name">名字：</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">年龄：</form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="id">编号：</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="password">密码：</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="receivePaper">是否接收论文？</form:label></td>
            <td><form:checkbox path="receivePaper"/></td>
        </tr>
        <tr>
            <td><form:label path="favoriteFramework">喜欢的框架</form:label></td>
            <td><form:checkboxes path="favoriteFramework" items="${webFrameworkList}"/></td>
        </tr>
        <tr>
            <td><form:label path="gender">性别：</form:label></td>
            <td><form:radiobutton path="gender" value="M" label="男"/></td>
            <td><form:radiobutton path="gender" value="F" label="女"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
