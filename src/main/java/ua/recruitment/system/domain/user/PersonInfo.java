package ua.recruitment.system.domain.user;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
@Embeddable
public class PersonInfo {

    private String firstName;
    private String lastName;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    private Gender gender;
    private String educationInfo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public String getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(final String educationInfo) {
        this.educationInfo = educationInfo;
    }
}
