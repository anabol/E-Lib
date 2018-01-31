package ru.AccountLib.hibernate.servlets;

import ru.AccountLib.hibernate.dao.Factory;
import ru.AccountLib.hibernate.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("log");
        String password = req.getParameter("password");
        UserEntity userEntity = new UserEntity();
        userEntity.setLog(log);
        userEntity.setPassword(password);
//        req.setAttribute("log", log);
        try {
            Factory.getInstance().getUserDAO().addUser(userEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/add"));
        req.setAttribute("log", log);
        doGet(req, resp);
    }
}
