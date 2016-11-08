package ua.recruitment.system.service.user.impl;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.service.user.UserFactory;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.dto.CreateUserRequest;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KIRIL on 07.11.2016.
 */
@Service
public class DefaultUserService implements UserService {

    private static final String USER_WITH_EMAIL_ALREADY_EXIST = "User with email:%s already exist";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFactory userFactory;

    @Override
    @Transactional
    public void registerUser(CreateUserRequest createUserRequest) {
        final String email = createUserRequest.getEmail();
        final long usersWithEmail = userRepository.countByEmail(email);
        Validate.isTrue(usersWithEmail < 1, String.format(USER_WITH_EMAIL_ALREADY_EXIST, email));
        User user = userFactory.createUser(createUserRequest);
        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getList(0, 100);
    }

    @Override
    public User getUserByEmail(final String email) {
        return userRepository.findByUserEmail(email);
    }
}
