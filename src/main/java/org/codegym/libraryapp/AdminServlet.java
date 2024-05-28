package org.codegym.libraryapp;

import org.codegym.libraryapp.Entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private List<User> users = new ArrayList<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        User u1 = new User(1, "admin", "1234", "30");
        User u2 = new User(2, "admin2", "1234", "30");
        User u3 = new User(3, "admin3", "1234", "30");
        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder text = new StringBuilder("<html><body>");
        text.append("<table>");
        for (User u : users) {
            text.append("<tr>");
            text.append("<td>").append(u.getId()).append("</td>");
            text.append("<td>").append(u.getUsername()).append("</td>");
            text.append("<td>").append(u.getPassword()).append("</td>");
            text.append("<td>").append(u.getAge()).append("</td>");
            text.append("</tr>");
        }
        text.append("</table>");
        text.append("</body></html>");
        out.println(text);
        out.close();
    }
}
