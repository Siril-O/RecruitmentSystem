package ua.recruitment.system.web.controller.position.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
public class ApplyPositionRequest {
    @NotNull
    private String positionCode;
    @NotNull
    private String applicantEmail;
    @NotNull
    private String curriculumVitae;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(final String positionCode) {
        this.positionCode = positionCode;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(final String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(final String curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }
}
