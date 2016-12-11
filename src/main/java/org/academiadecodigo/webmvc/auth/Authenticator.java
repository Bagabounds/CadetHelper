package org.academiadecodigo.webmvc.auth;

import org.academiadecodigo.webmvc.model.User;
import org.academiadecodigo.webmvc.service.UserService;

/**
 * Created by codecadet on 08/12/16.
 */
public class Authenticator {

    UserService userService;

    public boolean authenticate(String email, String password) {

        User user = userService.find(email);

        return user != null && user.getEmail().equals(email) && user.getPassword().equals(password);

    }

    public void register(String name, String role, String email, String password){
            userService.addUser(new User(name, role, email, password));
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
