package org.academiadecodigo.webmvc.service;

import org.academiadecodigo.webmvc.model.User;

/**
 * Created by codecadet on 08/12/16.
 */
public interface UserService {

    public void addUser(User user);

    public User find(String toFind );

    public int count();

}
