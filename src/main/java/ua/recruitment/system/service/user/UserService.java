package ua.recruitment.system.service.user;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.web.controller.user.dto.CreateUserRequest;

import java.util.List;

/**
 * Created by KIRIL on 07.11.2016.
 */
public interface UserService {

    void registerUser(CreateUserRequest createUserDto);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    <T extends User> T getUserByEmail(String email, Class<T> tClass);

    List<User> getUsersByEmails(List<String> emails);

    <T extends User> List<T> getUsersByEmails(List<String> emails, Class<T> userTypeClass);

    void assignRecruiterToCompany(String email, String companyName);
}
