<%@ page import="java.util.List" %>
<%@ page import="org.codegym.libraryapp.Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/29/24
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <a href="/admin/create">Create</a>
    <tr>
        <td>#</td>
        <td>UserName</td>
        <td>Age</td>
        <td></td>
    </tr>
    <c:set var="i" value="1"/>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${i}</td>
            <td>${user.username}</td>
            <td>${user.age}</td>
            <td><a href="/admin/delete?id=<c:out value="${user.id}"/>">Delete</a></td>
            <td><a href="/admin/update?id=<c:out value="${user.id}"/>">Update</a></td>
        </tr>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
</table>
</body>
</html>
