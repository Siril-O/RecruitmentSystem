package ua.recruitment.system.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void create(User entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(User entity) {

    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getList(Integer startPosition, Integer maxResults) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.find", User.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public Long getTotalResultCount() {
        return null;
    }

    @Override
    public void refresh(User entity) {

    }

    @Override
    public User findByUserEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
