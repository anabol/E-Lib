package ru.AccountLib.hibernate.servlets;

import ru.AccountLib.hibernate.dao.Factory;
import ru.AccountLib.hibernate.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/views/registView.jsp");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserEntity userEntity = new UserEntity(req.getParameter("password"), req.getParameter("log"), req.getParameter("gender"));
            Factory.getInstance().getUserDAO().addUser(userEntity);
        } catch (SQLException e){
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/login"));
    }
}
