package ua.recruitment.system.web.controller.position.dto;

import ua.recruitment.system.domain.PositionApplicationStatus;

import java.util.List;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
public class GetPositionApplicationsRequest {

    private List<String> positionCodes;
    private List<String> applicantEmails;
    private List<PositionApplicationStatus> statuses;

    public List<String> getPositionCodes() {
        return positionCodes;
    }

    public void setPositionCodes(final List<String> positionCodes) {
        this.positionCodes = positionCodes;
    }

    public List<String> getApplicantEmails() {
        return applicantEmails;
    }

    public void setApplicantEmails(final List<String> applicantEmails) {
        this.applicantEmails = applicantEmails;
    }

    public List<PositionApplicationStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(final List<PositionApplicationStatus> statuses) {
        this.statuses = statuses;
    }
}
