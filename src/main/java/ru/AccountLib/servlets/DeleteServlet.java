package ru.AccountLib.servlets;

import ru.AccountLib.dao.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Factory.getInstance().getUserDAO().deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            List<UserEntity> users = Factory.getInstance().getUserDAO().getAllUsers();
//            req.setAttribute("users", users);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
//        requestDispatcher.forward(req, resp);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/list"));
    }
}
