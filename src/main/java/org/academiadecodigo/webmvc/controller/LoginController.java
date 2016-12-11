package org.academiadecodigo.webmvc.controller;

import org.academiadecodigo.webmvc.auth.Authenticator;
import org.academiadecodigo.webmvc.model.User;
import org.academiadecodigo.webmvc.service.MockUserService;
import org.academiadecodigo.webmvc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by codecadet on 08/12/16.
 */
public class LoginController extends HttpServlet {

   // User user = new User("Tomás Amaro","tomascorreiamaro@gmail.com", "teste");

    private String email;
    private String password;
    private UserService userService;
    private Authenticator authenticator;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("UserService");
        authenticator = (Authenticator) getServletContext().getAttribute("Auth");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");

        //This is here just to test the user creation
        userService.addUser(new User("Tomás Amaro", "Code Cadet", "tomascorreiamaro@gmail.com", "teste"));

        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //   throw new ServletException();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/cadet_home.jsp");
        email = req.getParameter("loginEmail");
        password = req.getParameter("loginPassword");

        if (authenticator.authenticate(email,password)) {
            User user = userService.find(email);
            user.setLogged(true);
            req.setAttribute("user",user);
            getServletContext().setAttribute("user", user);
            resp.sendRedirect("cadet_home");

        } else {

            resp.getWriter().printf("User not found on email %s ", email);
        }
    }



}
