package ua.recruitment.system.facade.impl;

import com.google.common.collect.Lists;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.user.Recruiter;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.facade.CompanyFacade;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.controller.company.dto.RegisterCompanyRequest;

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
        String recruiterEmail = registerCompanyRequest.getRecruiterEmail();
        if (recruiterEmail != null) {
            User recruiter = userService.getUserByEmail(recruiterEmail);
            Validate.isTrue(recruiter instanceof Recruiter, String.format(
                    "Provided recruiter with email:%s is not Recruiter", recruiterEmail));
            company.setRecruiters(Lists.newArrayList((Recruiter) recruiter));
        }
        companyService.registerCompany(company);
    }
}
