package ua.recruitment.system.web.controller.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ua.recruitment.system.domain.user.ApplicantStatus;
import ua.recruitment.system.domain.user.Gender;
import ua.recruitment.system.domain.user.Role;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by KIRIL on 06.11.2016.
 */
public class CreateUserRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Gender gender;
    @NotNull
    private Role role;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

    private String educationInfo;
    private ApplicantStatus applicantStatus;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public ApplicantStatus getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(final ApplicantStatus applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(String educationInfo) {
        this.educationInfo = educationInfo;
    }
}
