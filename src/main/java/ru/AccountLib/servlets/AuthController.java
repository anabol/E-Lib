package ru.AccountLib.servlets;

import ru.AccountLib.dao.Factory;
import ru.AccountLib.dao.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

public class AuthController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("log");
        String password = req.getParameter("password");

        UserEntity user = new UserEntity();

        List<UserEntity> userEntities = Factory.getInstance().getUserDAO().getUser(login);
        Iterator<UserEntity> iterator = userEntities.iterator();
        if(iterator.hasNext()){
            user = iterator.next();
            req.setAttribute("user", user);
        } else {
            req.setAttribute("errorMessage", "Login don't have");
        }

        if (login.equals((user.getLog())) && password.equals(user.getPassword()) && "ADMIN".equals(user.getRole())){
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } else if (login.equals((user.getLog())) && password.equals(user.getPassword()) && "USER".equals(user.getRole())){
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Login or login incorrect");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
