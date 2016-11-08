package ua.recruitment.system.web.controller.company.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public class RegisterCompanyRequest {

    @NotNull
    private String name;
    @NotNull
    private String description;
    private String recruiterEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }
}
