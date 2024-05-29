package org.codegym.libraryapp;

import org.codegym.libraryapp.Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/*"})
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
        String url = req.getPathInfo();
        System.out.println(url);
        switch (url) {
            case "/create": {
                renderPageCreate(req, resp);
                break;
            }
            case "/list": {
                renderPageList(req, resp);
                break;
            }
            case "/delete":
                deleteUser(req, resp);
                break;
            case "/update":
                renderPageUpdate(req, resp);
                break;
        }
    }

    private void renderPageUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUpdate = req.getParameter("id");
        User userUpdate = findUser(Integer.parseInt(idUpdate));
        req.setAttribute("user", userUpdate);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        // tim user theo id:
        User userDelete = findUser(Integer.parseInt(id));
        // delete user from users
        users.remove(userDelete);
        resp.sendRedirect("/admin/list");
    }

    private void renderPageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private static void renderPageCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lay path url hien tai
        String url = req.getPathInfo();
        if (url.equals("/create")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String age = req.getParameter("age");
            User user = new User(users.size() + 1, username, password, age);
            users.add(user);
            resp.sendRedirect("/admin/list");
        } else if(url.equals("/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            User userUpdate = findUser(id);
            // get du lieu
            String username = req.getParameter("username");
            String age = req.getParameter("age");
            // set lai gia tri
            userUpdate.setUsername(username);
            userUpdate.setAge(age);
            resp.sendRedirect("/admin/list");
        }
    }

    protected User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
