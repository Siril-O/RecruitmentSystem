package ua.recruitment.system.domain.user;

import ua.recruitment.system.domain.PositionApplication;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
@Entity
@DiscriminatorValue(value = "APPLICANT")
public class Applicant extends User {

    @OneToMany(mappedBy = "applicant")
    private List<PositionApplication> positionApplications;
    private ApplicantStatus applicantStatus;


    public List<PositionApplication> getPositionApplications() {
        return positionApplications;
    }

    public void setPositionApplications(final List<PositionApplication> positionApplications) {
        this.positionApplications = positionApplications;
    }

    public ApplicantStatus getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(final ApplicantStatus applicantStatus) {
        this.applicantStatus = applicantStatus;
    }
}
