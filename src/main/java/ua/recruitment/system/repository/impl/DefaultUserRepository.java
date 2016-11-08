package ua.recruitment.system.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.repository.util.Paging;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Repository
public class DefaultUserRepository extends AbstractRepository<User> implements UserRepository {

    @Override
    @Transactional
    public void create(User entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(User user) {
        if (user != null && user.getId() != null) {
            persist(user, false);
        }
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getList(Optional<Paging> pagingOptional) {
        return getList(pagingOptional, "User.find", User.class);
    }

    @Override
    public Long getTotalResultCount() {
        return getTotalResultCount("User.getTotalCount");
    }

    @Override
    public void refresh(User entity) {
        entityManager.refresh(entity);
    }

    @Override
    public User findByUserEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public long countByEmail(final String email) {
        Query query = entityManager.createNamedQuery("User.countByEmail");
        query.setParameter("email", email);
        return (long) query.getSingleResult();
    }
}
