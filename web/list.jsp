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
<a href="/lab6_war_exploded/index.jsp">back</a> <br>
<table  border="1">
  <a>Artist table</a> <br>
  <tr>
    <td>id</td>
    <td>name</td>
  </tr>
  <c:forEach items="${list}" var="list">
    <tr>
      <th>${list.id}</th>
      <th>${list.name}</th>
      <th><a href="/lab6_war_exploded/save_all?action=update&type=art&id=<c:out value="${list.id}"/>">update</a> </th>
      <th><a href="/lab6_war_exploded/save_all?action=delete&type=art&id=${list.id}">delete</a> </th>
    </tr>
  </c:forEach>

</table>
<table  border="1">
  <a>Album table</a> <br>
  <tr>
    <td>id</td>
    <td>name</td>
    <td>type</td>
    <td>artist</td>
  </tr>
  <c:forEach items="${albums}" var="albums">
    <tr>
      <th>${albums.id}</th>
      <th>${albums.name}</th>
      <th>${albums.type}</th>
      <th>${albums.artist.id}</th>
      <th><a href="/lab6_war_exploded/save_all?action=update&type=alb&id=<c:out value="${albums.id}"/>">update</a> </th>
      <th><a href="/lab6_war_exploded/save_all?action=delete&type=alb&id=${albums.id}">delete</a> </th>
    </tr>
  </c:forEach>
</table>

<table  border="1">
  <a>Track table</a> <br>
  <tr>
    <td>id</td>
    <td>name</td>
    <td>time</td>
    <td>artist</td>
    <td>album</td>
  </tr>
  <c:forEach items="${track}" var="track">
    <tr>
      <th>${track.id}</th>
      <th>${track.name}</th>
      <th>${track.time}</th>
      <th>${track.artist.id}</th>
      <th>${track.album.id}</th>
      <th><a href="/lab6_war_exploded/save_all?action=update&type=tr&id=<c:out value="${track.id}"/>">update</a> </th>
      <th><a href="/lab6_war_exploded/save_all?action=delete&type=tr&id=${track.id}">delete</a> </th>
    </tr>
  </c:forEach>
</table>

<table  border="1">
  <a>Result table</a> <br>
  <tr>
    <td>id</td>
    <td>name</td>
    <td>artist</td>
  </tr>
  <c:forEach items="${result}" var="result">
    <tr>
      <th>${result.id}</th>
      <th>${result.name}</th>
      <th>${result.artist.id}</th>
    </tr>
  </c:forEach>
</table>

</body>
</html>
