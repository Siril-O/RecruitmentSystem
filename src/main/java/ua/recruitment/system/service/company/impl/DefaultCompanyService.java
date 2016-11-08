package ua.recruitment.system.service.company.impl;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.repository.CompanyRepository;
import ua.recruitment.system.service.company.CompanyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Service
public class DefaultCompanyService implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void registerCompany(String name, String description) {
        Company company = new Company();
        company.setDescription(description);
        company.setName(name);
        companyRepository.create(company);
    }

    @Override
    public List<Company> getCompanies(){
        return companyRepository.getList(0, 100);
    }

}
