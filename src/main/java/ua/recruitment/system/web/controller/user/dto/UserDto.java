package ua.recruitment.system.web.controller.user.dto;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String userRole;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(final String userRole) {
        this.userRole = userRole;
    }
}
