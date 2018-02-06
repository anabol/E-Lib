package ru.AccountLib.hibernate.servlets;

import ru.AccountLib.hibernate.dao.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class DeleteBookServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        try {
            Factory.getInstance().getUserLibDAO().deleteUserBook(userId, bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/userAccount"));
    }
}
