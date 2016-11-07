package ua.recruitment.system.web.response;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;

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
}
