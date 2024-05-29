<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
    <%
        System.out.println("Xin chao");
    %>
    <%!
        public void jspInit(){
            System.out.println("Initializing jsp");
        }

        public void jspDestroy(){
            System.out.println("Destroying jsp");
        }
    %>

</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="/login">Login</a>
</body>
</html>