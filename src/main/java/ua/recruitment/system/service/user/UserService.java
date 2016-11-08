package ua.recruitment.system.service.user;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.web.dto.CreateUserRequest;

import java.util.List;

/**
 * Created by KIRIL on 07.11.2016.
 */
public interface UserService {

    void registerUser(CreateUserRequest createUserDto);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    }
