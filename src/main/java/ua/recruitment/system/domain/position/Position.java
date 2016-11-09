package ua.recruitment.system.domain.position;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.PositionApplication;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
@NamedQueries({
        @NamedQuery(name = "Position.find", query = "SELECT p FROM Position AS p"),
        @NamedQuery(name = "Position.findByCode", query = "SELECT p FROM Position AS p WHERE p.code=:code"),
        @NamedQuery(name = "Position.getTotalCount", query = "SELECT count(p.id) FROM Position AS p"),
        @NamedQuery(name = "Position.findInStatuses", query = "SELECT p FROM Position AS p WHERE p.positionStatus IN (:statuses)"),
})


@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    private String name;
    private String description;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateOfCreation;
    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(final Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(final PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
    }
}
