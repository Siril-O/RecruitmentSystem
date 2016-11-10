package ua.recruitment.system.service.user;

import ua.recruitment.system.domain.user.Applicant;
import ua.recruitment.system.domain.user.PersonInfo;
import ua.recruitment.system.domain.user.Recruiter;
import ua.recruitment.system.domain.user.Role;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.web.controller.user.dto.CreateUserRequest;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Component
public class UserFactory {

    private static final Logger LOG = LoggerFactory.getLogger(UserFactory.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest createUserRequest) {
        Validate.isTrue(createUserRequest.getRole() != null, "Cannot create user without role");
        User user = null;
        if (Role.APPLICANT == createUserRequest.getRole()) {
            user = createApplicant(createUserRequest);
        } else if (Role.RECRUITER == createUserRequest.getRole()) {
            user = createRecruiter(createUserRequest);
        }
        return user;
    }

    private Applicant createApplicant(CreateUserRequest createUserRequest) {
        Applicant applicant = new Applicant();
        populateUser(createUserRequest, applicant);
        applicant.setApplicantStatus(createUserRequest.getApplicantStatus());
        return applicant;
    }

    private Recruiter createRecruiter(CreateUserRequest createUserRequest) {
        Recruiter recruiter = new Recruiter();
        populateUser(createUserRequest, recruiter);
        return recruiter;
    }

    private void populateUser(CreateUserRequest createUserRequest, User user) {
        PersonInfo personalInfo = new PersonInfo();
        personalInfo.setFirstName(createUserRequest.getFirstName());
        personalInfo.setLastName(createUserRequest.getLastName());
        personalInfo.setGender(createUserRequest.getGender());
        user.setEmail(createUserRequest.getEmail());
        user.setPersonInfo(personalInfo);
        user.setRole(createUserRequest.getRole());
        user.setPasswordHash(passwordEncoder.encode(createUserRequest.getPassword()));
    }

}
