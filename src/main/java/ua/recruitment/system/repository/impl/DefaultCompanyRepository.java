package ua.recruitment.system.repository.impl;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.repository.CompanyRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Repository
public class DefaultCompanyRepository implements CompanyRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void create(final Company entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(final Company entity) {
        entityManager.merge(entity);

    }

    @Override
    public Company findById(final Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getList(final Integer startPosition, final Integer maxResults) {
        TypedQuery<Company> query = entityManager.createNamedQuery("Company.find", Company.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public Long getTotalResultCount() {
        return null;
    }

    @Override
    public void refresh(final Company entity) {

    }
}
