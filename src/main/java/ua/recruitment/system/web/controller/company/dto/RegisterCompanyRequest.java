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
}
