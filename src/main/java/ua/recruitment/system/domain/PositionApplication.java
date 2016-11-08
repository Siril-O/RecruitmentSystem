package ua.recruitment.system.domain;

import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.user.Applicant;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
@Entity
public class PositionApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;
    @ManyToOne
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
