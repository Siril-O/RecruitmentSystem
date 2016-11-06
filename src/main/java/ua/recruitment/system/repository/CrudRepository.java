package ua.recruitment.system.repository;

import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
public interface CrudRepository<T> {

    void create(final T entity);

    void update(final T entity);

    T findById(final Long id);

    List<T> getList(final Integer startPosition, final Integer maxResults);

    Long getTotalResultCount();

    void refresh(T entity);
}
