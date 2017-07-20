<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/20
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="" action="dologin" method="post">
    <label>User Name</label> <input tyep="text" name="name" maxLength="40" />
    <label>Password</label><input type="password"  name="password" />
    <input type="submit" value="login" />
</form>
<%--用于输入后台返回的验证错误信息 --%>
<p><c:out value="${message }" /></p>
</body>
</html>
