<%--
  Created by IntelliJ IDEA.
  User: nbiryulin
  Date: 10.12.2021
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save">
  <input type="text" name="id" readonly="readonly" value="<c:out value="${artist.id}"/>">
  <input type="text" name="name" value="<c:out value="${artist.name}"/>">
  <input type="submit" value="ok" name="update">
</form>
</body>
</html>
