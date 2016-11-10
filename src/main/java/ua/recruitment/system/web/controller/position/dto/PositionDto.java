package ua.recruitment.system.web.controller.position.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.web.controller.company.dto.CompanyDto;

import java.util.Date;

/**
 * Created by KIRIL on 08.11.2016.
 */
public class PositionDto {
    private String name;
    private String description;
    private String code;
    private CompanyDto company;
    private PositionStatus positionStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreation;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
