package ua.recruitment.system.web.controller.company;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.facade.CompanyFacade;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.web.controller.company.converter.CompanyToDtoConverter;
import ua.recruitment.system.web.controller.company.dto.CompanyDto;
import ua.recruitment.system.web.controller.company.dto.RegisterCompanyRequest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Controller
@RequestMapping("/company")
@Secured("isAuthenticated()")
public class CompanyController {

    @Autowired
    private CompanyService companySerice;
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyToDtoConverter companyToDtoConverter;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Secured("hasRole(RECRUITER)")
    public void registerCompany(@RequestBody @Valid RegisterCompanyRequest request) {
        companyFacade.registerCompany(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyDto> getCompanies() {
        List<Company> companies = companySerice.getCompanies();
        return companyToDtoConverter.convert(companies);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void editCompany(@RequestBody @Valid RegisterCompanyRequest request) {
        companyFacade.updateCompany(request);
    }
}
