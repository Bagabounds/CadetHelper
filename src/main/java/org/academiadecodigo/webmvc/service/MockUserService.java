package org.academiadecodigo.webmvc.service;

import org.academiadecodigo.webmvc.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by codecadet on 08/12/16.
 */
public class MockUserService implements UserService {

    private Map<String,User> users = new LinkedHashMap<>();


    @Override
    public void addUser(User user) {
        users.put(user.getEmail(),user);
    }

    @Override
    public User find(String toFind) {
        return users.get(toFind);
    }

    @Override
    public int count() {
        return users.size();
    }
}
