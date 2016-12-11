package org.academiadecodigo.webmvc.app;

import org.academiadecodigo.webmvc.auth.Authenticator;
import org.academiadecodigo.webmvc.service.MockUserService;
import org.academiadecodigo.webmvc.service.UserService;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by codecadet on 08/12/16.
 */
public class App implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserService userService = new MockUserService();
        Authenticator authenticator = new Authenticator();
        authenticator.setUserService(userService);

        servletContextEvent.getServletContext().setAttribute("Auth",authenticator);
        servletContextEvent.getServletContext().setAttribute("UserService",userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
