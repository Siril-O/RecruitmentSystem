package ua.recruitment.system.domain;

import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.user.Applicant;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
@NamedQueries({
        @NamedQuery(name = "PositionApplication.find", query = "SELECT p FROM PositionApplication AS p"),
        @NamedQuery(name = "PositionApplication.getTotalCount", query = "SELECT count(p.id) FROM PositionApplication AS p"),
})

@Entity
public class PositionApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "POSITION_ID")
    private Position position;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "APPLICANT_ID")
    private Applicant applicant;
    private String curriculumVitae;
    @Enumerated(EnumType.STRING)
    private PositionApplicationStatus status;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date applyDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastStatusChangeDate;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(final Applicant applicant) {
        this.applicant = applicant;
    }

    public String getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(final String curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    public PositionApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(final PositionApplicationStatus status) {
        this.status = status;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(final Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getLastStatusChangeDate() {
        return lastStatusChangeDate;
    }

    public void setLastStatusChangeDate(final Date lastStatusChangeDate) {
        this.lastStatusChangeDate = lastStatusChangeDate;
    }
}
