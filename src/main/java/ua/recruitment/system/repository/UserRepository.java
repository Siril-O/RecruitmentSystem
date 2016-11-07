package ua.recruitment.system.repository;

import ua.recruitment.system.domain.user.User;

/**
 * Created by KIRIL on 06.11.2016.
 */
public interface UserRepository extends CrudRepository<User> {

    User findByUserEmail(String userName);
}
