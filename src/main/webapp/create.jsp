<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/29/24
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create</h1>
<form action="/admin/create" method="post">
    username: <input type="text" name="username"/>
    password: <input type="text" name="password"/>
    age: <input type="text" name="age"/>
    <input type="submit" name="submit" value="Submit"/>
</form>
</body>
</html>
