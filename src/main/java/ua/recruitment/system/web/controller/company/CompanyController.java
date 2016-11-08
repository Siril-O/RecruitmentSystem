package ua.recruitment.system.web.controller.company;

import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.web.controller.company.dto.RegisterCompanyRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CompanyController {

    @Autowired
    private CompanyService companySerice;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void registerCompany(@RequestBody @Valid RegisterCompanyRequest request) {
        companySerice.registerCompany(request.getName(), request.getDescription());
    }
}
