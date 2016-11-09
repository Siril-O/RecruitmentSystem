package ua.recruitment.system.repository;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.util.CrudRepository;

import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
public interface UserRepository extends CrudRepository<User> {

    User findByUserEmail(String email);

    <T extends User> T findByUserEmail(String email, Class<T> tClass);

    long countByEmail(String email);

    List<User> findByUserEmails(List<String> emails);

    <T extends User> List<T> findByUserEmails(List<String> emails, Class<T> tClass);

}
