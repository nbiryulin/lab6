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
<form method="post" action="/lab6_war_exploded/save_all">
    <input type="text" name="id" readonly="readonly" value="<c:out value="${track.id}"/>">
    <input type="text" name="name" value="<c:out value="${track.name}"/>">
    <input type="text" name="time" value="<c:out value="${track.time}"/>">
    <input type="submit" value="ok" name="update">
    <input type="hidden" value="tr" name="types">
</form>
</body>
</html>
