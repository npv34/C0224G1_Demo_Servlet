<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/29/24
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int i = 5; %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2><%= i %></h2>
<c:set value="10" var="name"/>
<c:out value="${name}"/>
<form action="/login" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="text" name="age">
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>