package ua.recruitment.system.facade.impl;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.user.Recruiter;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.facade.CompanyFacade;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.controller.company.dto.RegisterCompanyRequest;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Component
public class DefaultCompanyFacade implements CompanyFacade {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Override
    public void registerCompany(RegisterCompanyRequest registerCompanyRequest) {
        Company company = new Company();
        company.setDescription(registerCompanyRequest.getDescription());
        company.setName(registerCompanyRequest.getName());
        company.setRecruiters(findRecruiters(registerCompanyRequest.getRecruiterEmails()));
        companyService.registerCompany(company);
    }

    @Override
    public void updateCompany(RegisterCompanyRequest registerCompanyRequest) {
        Company company = companyService.findByName(registerCompanyRequest.getName());
        company.setDescription(registerCompanyRequest.getDescription());
        company.setRecruiters(findRecruiters(registerCompanyRequest.getRecruiterEmails()));
        companyService.registerCompany(company);
    }

    private List<Recruiter> findRecruiters(List<String> emails){
        if (emails != null && !emails.isEmpty()) {
            List<Recruiter> users = userService.getUsersByEmails(emails, Recruiter.class);
            return users.stream().map(this::castToRecruiter).collect(Collectors.toList());
        }
        return  null;
    }

    private Recruiter castToRecruiter(User user) {
        final String errorMessage = String.format("Provided recruiters with recruiter:%s is not Recruiter", user.getEmail());
        Validate.isTrue(user instanceof Recruiter, errorMessage);
        return (Recruiter) user;
    }
}
