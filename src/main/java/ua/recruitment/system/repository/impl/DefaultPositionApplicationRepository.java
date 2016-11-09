package ua.recruitment.system.repository.impl;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.repository.PositionApplicationRepository;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.util.Paging;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Repository
public class DefaultPositionApplicationRepository extends AbstractRepository<PositionApplication>
        implements PositionApplicationRepository {

    @Override
    @Transactional
    public void create(final PositionApplication entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(final PositionApplication positionApplication) {
        if (positionApplication != null && positionApplication.getId() != null) {
            persist(positionApplication, false);
        }
    }

    @Override
    public PositionApplication findById(final Long id) {
        return entityManager.find(PositionApplication.class, id);
    }

    @Override
    public List<PositionApplication> getList(Optional<Paging> pagingOptional) {
        return getList(pagingOptional, "PositionApplication.find", PositionApplication.class);
    }

    @Override
    public PositionApplication findPositionApplicationByCode(final String code) {
        TypedQuery<PositionApplication> query = entityManager.createNamedQuery("PositionApplication.findByCode", PositionApplication.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    public Long getTotalResultCount() {
        return getTotalResultCount("PositionApplication.getTotalCount");
    }

    @Override
    public void refresh(final PositionApplication entity) {
        entityManager.refresh(entity);
    }
}
