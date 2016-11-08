package ua.recruitment.system.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.Company;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.CompanyRepository;
import ua.recruitment.system.repository.util.Paging;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Repository
public class DefaultCompanyRepository extends AbstractRepository<Company> implements CompanyRepository {

    @Override
    @Transactional
    public void create(final Company entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(final Company company) {
        if (company != null && company.getId() != null) {
            persist(company, false);
        }
    }

    @Override
    public Company findById(final Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getList(Optional<Paging> pagingOptional) {
        return getList(pagingOptional, "Company.find", Company.class);
    }

    @Override
    public Long getTotalResultCount() {
        return getTotalResultCount("Company.getTotalCount");
    }

    @Override
    public void refresh(final Company entity) {
        entityManager.refresh(entity);
    }

    @Override
    public Company findByName(String name) {
        TypedQuery<Company> query = entityManager.createNamedQuery("Company.findByName", Company.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
