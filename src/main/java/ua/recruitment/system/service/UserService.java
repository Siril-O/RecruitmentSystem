package ua.recruitment.system.service;

import ua.recruitment.system.domain.user.User;

import java.util.List;

/**
 * Created by KIRIL on 07.11.2016.
 */
public interface UserService {

    void saveUser(User user, String password);

    List<User> getAllUsers();

}
