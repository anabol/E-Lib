package ru.AccountLib.hibernate.servlets;

import ru.AccountLib.hibernate.dao.Factory;
import ru.AccountLib.hibernate.entity.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/addBookView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity bookEntity = new BookEntity();
        String bookName = req.getParameter("bookName");
        String bookAuth = req.getParameter("bookAuth");
        String bookText = req.getParameter("book");
        Factory.getInstance().getBookDAO().addBook(bookName, bookAuth, bookText);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/library"));
    }
}
