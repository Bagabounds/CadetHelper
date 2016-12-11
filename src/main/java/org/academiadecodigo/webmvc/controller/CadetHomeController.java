package org.academiadecodigo.webmvc.controller;

import org.academiadecodigo.webmvc.auth.Authenticator;
import org.academiadecodigo.webmvc.model.User;
import org.academiadecodigo.webmvc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by ra-fa on 10-Dec-16.
 */
public class CadetHomeController extends HttpServlet {

    private UserService userService;
    private Authenticator authenticator;
    private User user;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("UserService");
        authenticator = (Authenticator) getServletContext().getAttribute("Auth");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcherhome = getServletContext().getRequestDispatcher("/WEB-INF/cadet_home.jsp");
        user = (User)getServletContext().getAttribute("user");
        if(user.isLogged()){
            out.println(user.getEmail());
            dispatcherhome.forward(req,resp);
        }
        else {resp.getWriter().printf("PLEASE LOGIN");}

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcherlogin = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        resp.getWriter().printf("ENTREI AQUI NESTA MERDA DEPOIS DE FAZER POST. CHORA AGORAAAA!!!");
        // dispatcherlogin.forward(req,resp);
    }
}
