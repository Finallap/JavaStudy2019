<%--
  Created by IntelliJ IDEA.
  User: Finallap
  Date: 2020/4/28
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring MVC上传文件示例</title>
</head>
<body>
<form:form method="post" modelAttribute="fileUpload" enctype="multipart/form-data">
    请选择一个文件上传：
    <input type="file" name="file">
    <input type="submit" name="提交上传">
</form:form>
</body>
</html>
