package ua.recruitment.system.repository.impl;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.util.Paging;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public <T extends User> T findByUserEmail(final String email, final Class<T> tClass) {
        TypedQuery<T> query = entityManager.createNamedQuery("User.findByEmailAndClass", tClass);
        query.setParameter("email", email);
        query.setParameter("class", tClass);
        return query.getSingleResult();
    }

    @Override
    public long countByEmail(final String email) {
        Query query = entityManager.createNamedQuery("User.countByEmail");
        query.setParameter("email", email);
        return (long) query.getSingleResult();
    }

    @Override
    public List<User> findByUserEmails(List<String> emails) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByEmails", User.class);
        query.setParameter("emails", emails);
        return query.getResultList();
    }

    @Override
    public <T extends User> List<T> findByUserEmails(final List<String> emails, final Class<T> tClass) {
        TypedQuery<T> query = entityManager.createNamedQuery("User.findByEmailsAndClass", tClass);
        query.setParameter("emails", emails);
        return query.getResultList();
    }
}
