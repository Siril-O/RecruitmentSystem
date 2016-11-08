package ua.recruitment.system.service.company.impl;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.recruitment.system.domain.Company;
import ua.recruitment.system.repository.CompanyRepository;
import ua.recruitment.system.service.company.CompanyService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Service
public class DefaultCompanyService implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void registerCompany(Company company) {
        companyRepository.create(company);
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.getList(Optional.empty());
    }

    @Override
    public Company findByName(String name) {
        Validate.notEmpty(name, "Company name can not be empty");
        return companyRepository.findByName(name);
    }

}
