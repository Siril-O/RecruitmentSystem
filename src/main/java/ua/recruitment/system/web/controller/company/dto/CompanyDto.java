package ua.recruitment.system.web.controller.company.dto;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public class CompanyDto {
    private String name;
    private String description;
    private String recruiterEmail;

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

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }
}
