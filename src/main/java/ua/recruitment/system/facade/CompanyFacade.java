package ua.recruitment.system.facade;

import ua.recruitment.system.web.controller.company.dto.RegisterCompanyRequest;

/**
 * Created by KIRIL on 08.11.2016.
 */
public interface CompanyFacade {

    void registerCompany(RegisterCompanyRequest registerCompanyRequest);
}
