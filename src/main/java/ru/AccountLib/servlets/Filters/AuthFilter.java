package ru.AccountLib.servlets.Filters;

import ru.AccountLib.dao.Factory;
import ru.AccountLib.dao.UserEntity;

import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("log");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("log")) &&
                nonNull(session.getAttribute("password"))) {

            String role = (String) session.getAttribute("role");

            moveToMenu(req, res, role);


        } else if (Factory.getInstance().getUserDAO().getUser(login, password).iterator().hasNext()) {

            final String role = ((UserEntity) Factory.getInstance().getUserDAO().getUser(login, password).get(0)).getRole();

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("log", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role);

        } else {

            moveToMenu(req, res,"UNKNOWN");
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {


        if (role.equals("ADMIN")) {

            req.getRequestDispatcher("views/list.jsp").forward(req, res);

        } else if (role.equals("USER")) {

            req.getRequestDispatcher("/views/edit.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/views/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}