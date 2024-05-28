package org.codegym.libraryapp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet initialization");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Login</h1>");
        out.println("<form action=\"/login\" method=\"post\">");
        out.println("Username: <input type=\"text\" name=\"username\"><br>");
        out.println("Password: <input type=\"text\" name=\"password\"><br>");
        out.println("<input type=\"submit\" value=\"Login\">");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xu ly request method POST
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // logic login
        if (username.equals("admin") && password.equals("12344")) {
            // chuyen huong url: /admin -> tao new request
            resp.sendRedirect("/admin");
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
