package org.codegym.libraryapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        // chuyen req, resp xuong loginJSPServlet
        requestDispatcher.forward(req, resp);
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
            HttpSession session = req.getSession();
            session.setAttribute("error", "Account not found");
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
