package ua.recruitment.system.repository.util;

import ua.recruitment.system.repository.util.Paging;

import java.util.List;
import java.util.Optional;

/**
 * Created by KIRIL on 06.11.2016.
 */
public interface CrudRepository<T> {

    void create(final T entity);

    void update(final T entity);

    T findById(final Long id);

    List<T> getList(Optional<Paging> pagingOptional);

    Long getTotalResultCount();

    void refresh(T entity);
}
