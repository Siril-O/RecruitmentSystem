package ua.recruitment.system.repository.util;

import ua.recruitment.system.repository.util.Paging;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public class AbstractRepository<T> {
    public final static int DEFAULT_START_POSITION = 0;
    public final static int DEFAULT_LIMIT = 5;

    @PersistenceContext
    protected EntityManager entityManager;

    protected Query resolvePaging(Paging paging, Query query) {
        if (paging != null) {
            query.setFirstResult(paging.getStartPosition());
            query.setMaxResults(paging.getMaxResults());
        } else {
            query.setFirstResult(DEFAULT_START_POSITION);
            query.setMaxResults(DEFAULT_LIMIT);
        }
        return query;
    }

    protected T persist(T entity, boolean create) {
        if (entity == null) {
            return null;
        }
        if (create) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        return entity;
    }


    protected T findById(final Long id, Class<? extends T> type) {
        if (id != null) {
            return entityManager.find(type, id);
        }
        return null;
    }

    protected <H extends T> List<H> getList(Paging paging, String queryString, Class<H> type) {
        TypedQuery<H> query = entityManager.createNamedQuery(queryString, type);
        resolvePaging(paging, query);
        return query.getResultList();
    }


    protected long getTotalResultCount(String queryString) {
        final Query queryTotal = entityManager.createNamedQuery(queryString);
        return (long) queryTotal.getSingleResult();
    }
}
