<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.codegym.libraryapp.Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/29/24
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User userUpdate = (User) request.getAttribute("user");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update</h1>
<form action="/admin/update?id=<%= userUpdate.getId() %>" method="post">
    username: <input type="text" name="username" value="<%= userUpdate.getUsername() %>"/>
    age: <input type="text" name="age" value="<%= userUpdate.getAge() %>" />
    <input type="submit" name="submit" value="Submit"/>
</form>
</body>
</html>

