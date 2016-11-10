package ua.recruitment.system.web.controller.position.dto;

import ua.recruitment.system.domain.PositionApplicationStatus;
import ua.recruitment.system.web.controller.user.dto.UserDto;

import java.util.Date;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
public class PositionApplicationDto {

    private String code;
    private PositionDto position;
    private UserDto applicant;
    private String curriculumVitae;
    private PositionApplicationStatus status;
    private Date applyDate;
    private Date lastStatusChangeDate;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(final PositionDto position) {
        this.position = position;
    }

    public UserDto getApplicant() {
        return applicant;
    }

    public void setApplicant(final UserDto applicant) {
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
