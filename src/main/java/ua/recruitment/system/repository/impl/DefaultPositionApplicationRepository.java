package ua.recruitment.system.repository.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.PositionApplicationRepository;
import ua.recruitment.system.repository.util.Paging;

import java.util.List;
import java.util.Optional;

/**
 * Created by KIRIL on 08.11.2016.
 */
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
    public Long getTotalResultCount() {
        return getTotalResultCount("PositionApplication.getTotalCount");
    }

    @Override
    public void refresh(final PositionApplication entity) {
        entityManager.refresh(entity);
    }
}
