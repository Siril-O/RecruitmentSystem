package ua.recruitment.system.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.repository.PositionRepository;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.util.Paging;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Repository
public class DefaultPositionRepository extends AbstractRepository<Position> implements PositionRepository {

    @Override
    @Transactional
    public void create(final Position entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(final Position position) {
        if (position != null && position.getId() != null) {
            persist(position, false);
        }
    }

    @Override
    public Position findById(final Long id) {
        return entityManager.find(Position.class, id);
    }

    @Override
    public List<Position> getList(Paging paging) {
        return getList(paging, "Position.find", Position.class);
    }

    @Override
    public Long getTotalResultCount() {
        return getTotalResultCount("Position.getTotalCount");
    }

    @Override
    public void refresh(final Position entity) {
        entityManager.refresh(entity);
    }

    @Override
    public List<Position> findPositionInStatuses(List<PositionStatus> statuses) {
        TypedQuery<Position> query = entityManager.createNamedQuery("Position.findInStatuses", Position.class);
        query.setParameter("statuses", statuses);
        return query.getResultList();
    }

    @Override
    public Position findPositionByCode(String code) {
        TypedQuery<Position> query = entityManager.createNamedQuery("Position.findByCode", Position.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }
}
