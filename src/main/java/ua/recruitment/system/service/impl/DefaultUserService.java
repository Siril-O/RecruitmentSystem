package ua.recruitment.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.service.UserService;

import java.util.List;

/**
 * Created by KIRIL on 07.11.2016.
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user, String password) {
        user.setPasswordHash(passwordEncoder.encode(password));
        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getList(0, 100);
    }
}
