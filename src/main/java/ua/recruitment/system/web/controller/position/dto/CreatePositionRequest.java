package ua.recruitment.system.web.controller.position.dto;

/**
 * Created by KIRIL on 08.11.2016.
 */
public class CreatePositionRequest {
    private String name;
    private String description;
    private String companyName;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
