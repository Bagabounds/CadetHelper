package org.academiadecodigo.webmvc.controller;

import org.academiadecodigo.webmvc.auth.Authenticator;
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
public class RegisterController extends HttpServlet {

    private String name;
    private String role;
    private String email;
    private String password;
    private String password2;
    private UserService userService;
    private Authenticator authenticator;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("UserService");
        authenticator = (Authenticator) getServletContext().getAttribute("Auth");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        name = request.getParameter("registerName");
        role = request.getParameter("registerRole");
        email = request.getParameter("registerEmail");
        password = request.getParameter("registerPassword");
        password2 = request.getParameter("registerPassword2");

        if(password.equals(password2)){
            authenticator.register(name,role,email,password);
            response.sendRedirect("/webmvc");
        }
        else {
            response.getWriter().printf("INVALID PASSWORD");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        dispatcher.forward(request, response);

    }
}
