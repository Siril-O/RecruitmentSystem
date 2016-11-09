package ua.recruitment.system.repository.impl;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.domain.PositionApplicationStatus;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.user.Applicant;
import ua.recruitment.system.repository.PositionApplicationRepository;
import ua.recruitment.system.repository.util.AbstractRepository;
import ua.recruitment.system.repository.util.Paging;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Repository
public class DefaultPositionApplicationRepository extends AbstractRepository<PositionApplication>
        implements PositionApplicationRepository {

    private static final String ID_FIELD = "id";

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


    @Override
    public List<PositionApplication> getFilteredPositionApplications(List<String> positionCodes, List<String> emails,
                                                                     List<PositionApplicationStatus> statuses) {
        CriteriaQuery<PositionApplication> criteriaQuery = buildQuery(positionCodes, emails, statuses);
        final TypedQuery<PositionApplication> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private CriteriaQuery<PositionApplication> buildQuery(List<String> positionCodes, List<String> emails,
                                                          List<PositionApplicationStatus> statuses) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PositionApplication> criteriaQuery = builder.createQuery(PositionApplication.class);

        Root<PositionApplication> positionApplicationRoot = criteriaQuery.from(PositionApplication.class);
        List<Predicate> criterias = new ArrayList<>();

        if (positionCodes != null && !positionCodes.isEmpty()) {
            Root<Position> positionRoot = criteriaQuery.from(Position.class);
            Path<Position> positionPath = positionApplicationRoot.get("position");
            Predicate positionJoinPredicate = builder.equal(positionPath.get(ID_FIELD), positionRoot.get(ID_FIELD));
            Predicate positionCodePredicate = builder.in(positionRoot.get("code")).value(positionCodes);
            criterias.add(positionJoinPredicate);
            criterias.add(positionCodePredicate);
        }

        if (emails != null && !emails.isEmpty()) {
            Root<Applicant> applicantRoot = criteriaQuery.from(Applicant.class);
            Path<Applicant> applicantPath = positionApplicationRoot.get("applicant");
            Predicate applicantJoinPredicate = builder.equal(applicantPath.get(ID_FIELD), applicantRoot.get(ID_FIELD));
            Predicate applicantEmailPredicate = builder.in(applicantRoot.get("email")).value(emails);
            criterias.add(applicantJoinPredicate);
            criterias.add(applicantEmailPredicate);
        }

        if (statuses != null && !statuses.isEmpty()) {
            Predicate statusPredicate = builder.in(positionApplicationRoot.get("status")).value(statuses);
            criterias.add(statusPredicate);
        }

        criteriaQuery.where(criterias.toArray(new Predicate[criterias.size()]));
        criteriaQuery.orderBy(builder.asc(positionApplicationRoot.get("applyDate")));
        return criteriaQuery;
    }
}
