<%--
  Created by IntelliJ IDEA.
  User: nbiryulin
  Date: 10.12.2021
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td>id</td>
    <td>name</td>
  </tr>
  <c:forEach items="${list}" var="list">
    <tr>
      <th>${list.id}</th>
      <th>${list.name}</th>
      <th><a href="/save?action=update&id=<c:out value="${list.id}"/>">update</a> </th>
      <th><a href="/save?action=delete&id=${list.id}">delete</a> </th>
    </tr>
  </c:forEach>
</table>
</body>
</html>
