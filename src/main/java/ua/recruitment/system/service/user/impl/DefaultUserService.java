package ua.recruitment.system.service.user.impl;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.user.Recruiter;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.service.exception.UniqueConstraintViolation;
import ua.recruitment.system.service.user.UserFactory;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.controller.user.dto.CreateUserRequest;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private CompanyService companyService;

    @Override
    @Transactional
    public void registerUser(CreateUserRequest createUserRequest) {
        final String email = createUserRequest.getEmail();
        final long usersWithEmail = userRepository.countByEmail(email);
        if (usersWithEmail > 0) {
            throw new UniqueConstraintViolation(String.format(USER_WITH_EMAIL_ALREADY_EXIST, email));
        }
        User user = userFactory.createUser(createUserRequest);
        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getList(null);
    }

    @Override
    public User getUserByEmail(final String email) {
        Validate.notEmpty(email, "Email can not be empty");
        return userRepository.findByUserEmail(email);
    }

    @Override
    public <T extends User> T getUserByEmail(final String email, final Class<T> tClass) {
        Validate.notEmpty(email, "Email can not be empty");
        Validate.notNull(tClass);
        return userRepository.findByUserEmail(email, tClass);
    }

    @Override
    public List<User> getUsersByEmails(final List<String> emails) {
        Validate.notEmpty(emails, "Emails can not be empty");
        return userRepository.findByUserEmails(emails);
    }

    @Override
    public <T extends User> List<T> getUsersByEmails(final List<String> emails, final Class<T> userTypeClass) {
        Validate.notEmpty(emails, "Emails can not be empty");
        return userRepository.findByUserEmails(emails, userTypeClass);
    }

    @Override
    public void assignRecruiterToCompany(final String email, final String companyName) {
        Validate.notEmpty(email);
        Validate.notEmpty(companyName);
        Company company = companyService.findByName(companyName);
        Recruiter recruiter = userRepository.findByUserEmail(email, Recruiter.class);
        recruiter.setCompany(company);
        userRepository.update(recruiter);
    }
}
