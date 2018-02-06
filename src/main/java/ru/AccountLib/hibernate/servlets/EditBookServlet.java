package ru.AccountLib.hibernate.servlets;

import com.mysql.fabric.FabricCommunicationException;
import ru.AccountLib.hibernate.dao.Factory;
import ru.AccountLib.hibernate.entity.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        BookEntity bookEntity = Factory.getInstance().getBookDAO().getBook(bookId);
        req.setAttribute("book", bookEntity);
        req.getRequestDispatcher("/views/editBookView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookText = req.getParameter("book");
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Factory.getInstance().getBookDAO().updateTextBook(bookId, bookText);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/library"));
    }
}
